package 练习.java1027;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @Author: ruan
 * Date: 2021/10/27 19:50
 * @Description: 手写ArrayList
 */
public class MyArrayList implements Serializable {
    /**
     * 并发标记
     */
    private transient int modCount = 0;
    /**
     * 默认首次扩容大小为10
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * 默认空的数组用于存放对象
     */
    private static final Object[] EMPTY_ELEMENT_DATA = {};

    /**
     * 实际存储数据的数组
     */
    transient Object[] elementData;
    /**
     * 实际大小
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
     */
    public MyArrayList(int initialCapacity){
        if (initialCapacity == 0){
            this.elementData = EMPTY_ELEMENT_DATA;
        }else if (initialCapacity > 0){
            this.elementData = new Object[initialCapacity];
        }else {
            throw new IllegalArgumentException("非法数据");
        }
    }

    /**
     * 扩容机制
     * @param minCapacity 最小容量
     */
    private void ensureCapacityInternal(int minCapacity){
        //首先判读是否是初次扩容
        if (elementData == EMPTY_ELEMENT_DATA){
            //是首次扩容
            minCapacity = Math.max(minCapacity,DEFAULT_CAPACITY);
        }
        //判断是否需要扩容
        if (elementData.length - minCapacity < 0){
            //容量不足需要扩容
            int oldCapacity = elementData.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            //判断扩容后是否可以使用
            if (newCapacity - minCapacity < 0){
                newCapacity = minCapacity;
            }
            //扩容完成创建新数组
            Object[] objects = new Object[newCapacity];
            //数据拷贝
            System.arraycopy(elementData,0,objects,0,elementData.length);
            //修改引用
            elementData = objects;
        }
    }

    /**
     * 下标检验
     * @param index 下标值
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
    public void add(Object o){
        //并发记录
        modCount++;
        //容量保证
        ensureCapacityInternal(size + 1);
        //尾部插入
        elementData[size++] = o;
    }

    /**
     * 根据下标获取数据
     * @param index 下标值
     * @return 对应数据
     */
    public Object get(int index){
        rangeCheck(index);
        return elementData[index];
    }

    /**
     * 根据数据获取下标
     * @param o 数据
     * @return 对应下标
     */
    public int indexOf(Object o){
        if (o == null){
            for (int i = 0; i < elementData.length; i++) {
                if (elementData[i] == null){
                    return i;
                }
            }
        }else {
            for (int i = 0; i < elementData.length; i++) {
                if (elementData[i] == o){
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 修改数据
     * @param index 待修改数据下标
     * @param o 新数据
     * @return 旧数据
     */
    public Object set(int index, Object o){
        //并发标记
        modCount++;
        //下标检查
        rangeCheck(index);
        //保存数据
        Object oleElement = elementData[index];
        //修改数据
        elementData[index] = o;
        return oleElement;
    }

    /**
     * 删除数据
     * @param index 要删除数据的下标
     * @return 旧数据
     */
    public Object del(int index){
        //并发标记
        modCount++;
        //下标检查
        rangeCheck(index);
        //保存数据
        Object oleElement = elementData[index];
        //计算待删除数据后面还有多少数据
        int munMove = size - index - 1;
        if (munMove > 0){
            //数据移动
            System.arraycopy(elementData,index + 1,elementData,index,munMove);
        }
        //尾部置空
        elementData[--size] = null;
        return oleElement;
    }

    /**
     * 数组大小
     * @return 数组大小
     */
    public int size(){
        return this.size;
    }

    public void list(){
        System.out.println(Arrays.toString(elementData));
    }

}
