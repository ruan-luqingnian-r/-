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
     * 标记位-是否被并发修改
     */
    private transient int modCount;

    /**
     * 默认扩容大小
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 默认初始数组
     */
    private static final Object[] EMPTY_ELEMENT_DATA = {};

    /**
     * 实际存储数据的数值
     */
    transient Object[] elementData;

    /**
     * 数组的大小
     */
    private int size;

    /**
     * 空参构造
     */
    public MyArrayList(){
        this.elementData = EMPTY_ELEMENT_DATA;
    }
    /**
     * 实参构造
     */
    public MyArrayList(int initialCapacity){
        if (initialCapacity == 0){
            this.elementData = EMPTY_ELEMENT_DATA;
        }else if (initialCapacity > 0){
            this.elementData = new Object[initialCapacity];
        }else {
            throw new IllegalArgumentException("参数错误");
        }
    }

    /**
     * 扩容机制--保证最小容量
     * @param minCapacity 最小容量
     */
    private void ensureCapacityInternal(int minCapacity){
        //判断是否是第一次进行扩容
        if (elementData == EMPTY_ELEMENT_DATA){
            //是第一次扩容,直接使用默认值或者最小值
            minCapacity = Math.max(minCapacity,DEFAULT_CAPACITY);
        }
        //如果不是第一次扩容并判断是否需要扩容
        if (elementData.length - minCapacity < 0){
            //数组长度不足需要扩容
            int oldCapacity = elementData.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            //比较新的容量和最小容量的大小
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
     * 下标检查
     * @param index 数组下标
     */
    private void rangIndex(int index){
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("数组越界");
        }
    }

    /**
     * 插入数据
     * @param o 待插入数据
     * @return 插入成功
     */
    public boolean add(Object o){
        //记录并发
        modCount++;
        //确保容量满足
        ensureCapacityInternal(size + 1);
        //插入数据
        elementData[size++] = o;
        return true;
    }

    /**
     * 根据下标获取数据
     * @param index 下标
     * @return 对应数据
     */
    public Object get(int index){
        //下标检查
        rangIndex(index);
        return elementData[index];
    }

    /**
     * 根据数据获取对应下标
     * @param o 数据
     * @return 对应下标
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
     * 根据下标修改数据
     * @param index 要修改的下标
     * @param o 待修改数据
     * @return 被修改的旧数据
     */
    public Object set(int index ,Object o){
        //并发记录
        modCount++;
        rangIndex(index);
        Object oldValue = elementData[index];
        elementData[index] = o;
        return oldValue;
    }

    /**
     * 根据下标删除数据
     * @param index 要删除数据的下标
     * @return 被删除的数据
     */
    public Object remove(int index){
        //并发记录
        modCount++;
        rangIndex(index);
        Object oldValue = elementData[index];
        //计算从删除位置之后还有多少数据
        int numMove = size - index - 1;
        if (numMove > 0){
            //移动数据
            System.arraycopy(elementData,index + 1,elementData,index,numMove);
        }
        //数组尾部置空
        elementData[--size] = null;
        return oldValue;
    }

    /**
     * 打印数据
     */
    public void list(){
        System.out.println(Arrays.toString(elementData));
    }

    /**
     * 获取数组长度
     * @return 数组长度
     */
    public int size(){
        return this.size;
    }



}
