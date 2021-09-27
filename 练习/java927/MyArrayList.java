package 练习.java927;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @Author: ruan
 * Date: 2021/9/27 15:22
 * @Description:
 */
public class MyArrayList implements Serializable {
    /**
     * 标识位---是否被并发修改
     */
    private transient int codCount = 0;

    /**
     * 默认第一次扩容大小
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 默认创建数组
     */
    private static final Object[] EMPTY_ELEMENT_DATA = {};

    /**
     * 实际存储的list
     */
    transient Object[] elementData;

    /**
     * list的大小
     */
    private int size;

    /**
     * 无参构造
     */
    public MyArrayList(){
        this.elementData = EMPTY_ELEMENT_DATA;
    }

    /**
     * 有参构造
     * @param initialCapacity 指定容量
     */
    public MyArrayList(int initialCapacity){
        if (initialCapacity == 0){
            this.elementData = EMPTY_ELEMENT_DATA;
        }else if (initialCapacity > 0){
            this.elementData = new Object[initialCapacity];
        }else {
            throw new IllegalArgumentException("数组越界");
        }
    }

    /**
     * 扩容方法
     * @param minCapacity 最小值
     */
    private void ensureCapacityInternal(int minCapacity){
        //判断是否是初次扩容
        if (elementData == EMPTY_ELEMENT_DATA){
            //如果是初次扩容
            minCapacity = Math.max(minCapacity,DEFAULT_CAPACITY);
        }
        //如果不是初次扩容，查看是否需要扩容
        if (elementData.length - minCapacity < 0){
            //需要扩容
            int oldCapacity = elementData.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            //判断扩容后的容量是否满足最小值
            if (newCapacity - minCapacity < 0){
                newCapacity = minCapacity;
            }
            //创建数组
            Object[] objects = new Object[newCapacity];
            //拷贝数据
            System.arraycopy(elementData,0,objects,0,elementData.length);
            //修改引用
            elementData = objects;
        }
    }

    /**
     * 检查下标
     * @param index 数组下标
     */
    private void rangeCheck(int index){
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("下标越界");
        }
    }

    /**
     * 添加数据
     * @param o 数据
     * @return 成功
     */
    public boolean add(Object o){
        //记录并发
        codCount++;
        //确保容量
        ensureCapacityInternal(size + 1);
        //添加数据
        elementData[size++] = o;
        return true;
    }

    /**
     * 获取对象的下标
     * @param o 对象
     * @return 下标
     */
    public int indexOf(Object o){
        if (o == null){
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null){
                    return i;
                }
            }
        }else {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == o){
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 根据下标获取数据
     * @param index 下标
     * @return 数据
     */
    public Object get(int index){
        rangeCheck(index);
        return elementData[index];
    }

    /**
     * 更新数据
     * @param index 数组下标
     * @param o 新数据
     * @return 旧数据
     */
    public Object set(int index,Object o){
        codCount++;
        rangeCheck(index);
        Object value = elementData[index];
        elementData[index] = o;
        return value;
    }

    /**
     * 根据索引删除数据
     * @param index 索引
     * @return 删除的数据
     */
    public Object remove(int index){
        codCount++;
        Object value = elementData[index];
        //计算后面还有多少数据
        int numMove = size - index - 1;
        //移动数据
        System.arraycopy(elementData,index + 1,elementData,index,numMove);
        //末尾置空
        elementData[--size] = null;
        return index;
    }

    /**
     * 打印内容
     */
    public void list(){
        System.out.println(Arrays.toString(elementData));
    }

}
