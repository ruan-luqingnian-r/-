package 练习;

import java.io.Serializable;

/**
 * @Author: ruan
 * Date: 2021/9/26 13:02
 * @Description: 简单的ArrayList
 */
public class MyArrayList implements Serializable {
    /**
     * 记录是否被并发修改
     */
    private transient int modCount = 0;
    /**
     * 默认初始扩容大小
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * 用于初始话的list
     */
    private static final Object[] EMPTY_ELEMENT_DATA = {};
    /**
     * 用于真正存储数据的list
     */
    transient Object[] elementData;
    /**
     * list的大小
     */
    private int size;

    /**
     * 无参构造函数
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
            throw new IllegalArgumentException("参数错误");
        }
    }
}
