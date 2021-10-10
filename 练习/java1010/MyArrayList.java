package 练习.java1010;

import java.io.Serializable;

/**
 * @Author: ruan
 * Date: 2021/10/10 13:46
 * @Description: 手写ArrayList
 */
public class MyArrayList implements Serializable {
    /**
     * 用于并发标记
     */
    private transient int codCount = 0;

    /**
     * 初次扩容容量10
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 空元素数组，用于初始化
     */
    private static final Object[] EMPTY_ELEMENT_DATA = {};

    /**
     * 实际用于存储数据的数组
     */
    private transient Object[] elementData;

    /**
     * 数组长度
     */
    private int size;

    /**
     * 相关构造方法
     */
    public MyArrayList(){
        this.elementData = EMPTY_ELEMENT_DATA;
    }
    public MyArrayList(int initialCapacity){
        if (initialCapacity == 0){
            this.elementData = EMPTY_ELEMENT_DATA;
        }else if (initialCapacity > 0){
            this.elementData = new Object[initialCapacity];
        }else {
            throw new IllegalArgumentException("参数异常");
        }
    }


}
