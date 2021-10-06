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



}
