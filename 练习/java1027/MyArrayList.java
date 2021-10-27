package 练习.java1027;

import java.io.Serializable;

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
     * @param minCapacity
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
        }

    }

}
