package 练习.java1010;

import java.io.Serializable;
import java.util.Arrays;

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

    /**
     * 插入数据
     * @param o
     */
    public void add(Object o){
        //并发标记
        codCount++;
        //容量确认
        ensureCapacityInternal(size + 1);
        //尾标插入
        elementData[size++] = o;
    }

    /**
     * 根据下标获取数据
     * @param index
     * @return
     */
    public Object get(int index){
        subscriptCheck(index);
        return elementData[index];
    }

    /**
     * 更新数据
     * @param index
     * @param o
     * @return
     */
    public Object set(int index,Object o){
        codCount++;
        subscriptCheck(index);
        Object elementDatum = elementData[index];
        elementData[index] = o;
        return elementDatum;
    }

    /**
     * 删除数据
     * @param index
     * @return
     */
    public Object remove(int index){
        codCount++;
        subscriptCheck(index);
        Object elementDatum = elementData[index];
        int munMove = size - index - 1;
        if (munMove > 0){
            System.arraycopy(elementData,index + 1,elementData,index,munMove);
        }
        elementData[--size] = null;
        return elementDatum;
    }

    /**
     * 获取大小
     * @return
     */
    public int size(){
        return this.size;
    }

    /**
     * 打印
     */
    public void list(){
        System.out.println(Arrays.toString(elementData));
    }

    /**
     * 容量确保
     * @param initialCapacity 所需最小容量
     */
    private void ensureCapacityInternal(int initialCapacity){
        //首先判断是否是初次扩容
        if (elementData == EMPTY_ELEMENT_DATA){
            //是初次扩容，使用最小容量 或 默认初次扩容容量
            initialCapacity = Math.max(initialCapacity,DEFAULT_CAPACITY);
        }
        //如果不是判断是否需要扩容
        if (elementData.length - initialCapacity < 0){
            //需要扩容
            int oldCapacity = elementData.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            if (newCapacity - initialCapacity < 0){
                newCapacity = initialCapacity;
            }
            //创建新数组
            Object[] objects = new Object[newCapacity];
            //数据拷贝
            System.arraycopy(elementData,0,objects,0,elementData.length);
            //修改引用
            elementData = objects;
        }
    }

    /**
     * 下标检查
     * @param index 下标
     */
    private void subscriptCheck(int index){
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("下标越界");
        }
    }


}
