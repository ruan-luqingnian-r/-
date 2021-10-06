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

    }



}
