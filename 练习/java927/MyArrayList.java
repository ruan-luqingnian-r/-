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
     * 是否被并发修改
     */
    private transient int modCount = 0;
    /**
     * 初次默认扩容大小
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * 初始换空数组
     */
    private static final Object[] EMPTY_ELEMENT_DATA = {};
    /**
     * 实际存储数据的数组
     */
    transient Object[] elementData;
    /**
     * 数组实际大小
     */
    private int size;

    /**
     * 无参构造方法
     */
    public MyArrayList(){
        this.elementData = EMPTY_ELEMENT_DATA;
    }
    /**
     * 实参构造方法
     */
    public MyArrayList(int initialCapacity){
        if (initialCapacity == 0){
            this.elementData = EMPTY_ELEMENT_DATA;
        }else if (initialCapacity > 0){
            this.elementData = new Object[initialCapacity];
        }else {
            throw new IllegalArgumentException("参数异常");
        }
    }
    /**
     * 容量保证
     * @param minCapacity 最小容量
     */
    private void ensureCapacityInternal(int minCapacity){
        //首先判断是否是初次扩容
        if (elementData == EMPTY_ELEMENT_DATA){
            //是初次扩容
            minCapacity = Math.max(minCapacity,DEFAULT_CAPACITY);
        }
        //如果不是初次扩容，判断是否需要进行扩容
        if (elementData.length - minCapacity < 0){
            //数组长度小于需要的最小值，需要进行扩容
            int oldCapacity = elementData.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            //判断扩容后的值是否满座最小值
            if (newCapacity - minCapacity < 0){
                newCapacity = minCapacity;
            }
            //创建新数组
            Object[] objects = new Object[newCapacity];
            //拷贝数据
            System.arraycopy(elementData,0,objects,0,elementData.length);
            //修改引用
            elementData = objects;
        }
    }
    /**
     * 下标校验
     * @param index 待检测下标
     */
    private void rangeCheck(int index){
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("数组越界");
        }
    }
    /**
     * 插入数据
     * @param o 待插入数据
     */
    public boolean add(Object o){
        //并发标记
        modCount++;
        //容量判断
        ensureCapacityInternal(size + 1);
        //插入数据
        elementData[++size] = o;
        return true;
    }

    /**
     * 根据下标获取数据
     * @param index 数据下标
     * @return 下标对应的数据
     */
    public Object get(int index){
        //下标判断
        rangeCheck(index);
        return elementData[index];
    }
    /**
     * 更新数据
     * @param index 要更新数据的下标
     * @param o 新数据
     * @return 旧数据
     */
    public Object set(int index,Object o){
        //并发标记
        modCount++;
        //下标检查
        rangeCheck(index);
        Object elementDatum = elementData[index];
        elementData[index] = o;
        return elementDatum;
    }

    /**
     * 获取对应数据的下标
     * @param o 数据
     * @return 对应的下标
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
     * 删除数据
     * @param index 待删除数据
     * @return 被删除的数据
     */
    public Object remove(int index){
        modCount++;
        rangeCheck(index);
        Object elementDatum = elementData[index];
        //待删除的数据后还有多少数据
        int numMove = size - index - 1;
        //移动数据
        System.arraycopy(elementData,index + 1,elementData,index,numMove);
        return elementDatum;
    }

    /**
     * 打印数据
     */
    public void list(){
        System.out.println(Arrays.toString(elementData));
    }
    /**
     * 获取数据
     */
    public int size(){
        return this.size;
    }
}
