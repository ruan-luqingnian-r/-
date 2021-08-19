package dataStructuresAndAlgoorithm.dataStructures.demo;

import java.io.Serializable;

/**
 * @Author: ruan
 * Date: 2021/8/19 15:54
 * @Description: 手写ArrayList
 */
public class MyArrayList implements Serializable {

    //第一次扩容的容量
    private static final int DEFAULT_CAPACITY = 10;

    //用于初始化空的list
    private static final Object[] EMPTY_ELEMENT_DATA = {};

    //实际储存的元素 transient使其无法序列化
    transient Object[] elementData;

    //实际存储list集合大小
    private int size;

    //空参构造函数
    public MyArrayList(){
        this.elementData = EMPTY_ELEMENT_DATA;
    }

    public MyArrayList(int initialCapacity){
        if (initialCapacity > 0){
            this.elementData = new Object[initialCapacity];
        }else if (initialCapacity == 0){
            this.elementData = EMPTY_ELEMENT_DATA;
        }else {
            throw new IllegalArgumentException("参数异常");
        }
    }

    //添加元素
    public boolean add(Object e){
        //判断容量
        ensureCapacityInternal(size + 1);
        //使用下标赋值,尾部插入
        elementData[size++] = e;
        return true;
    }


    //计算容量+确保容量
    private void ensureCapacityInternal(int minCapacity){
        //初次扩容则使用默认容量
        if (elementData == EMPTY_ELEMENT_DATA){
            minCapacity = Math.max(DEFAULT_CAPACITY,minCapacity);
        }
        //判断是否需要扩容
        if (minCapacity - elementData.length > 0){
            int oldCapacity = elementData.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            //如果新的容量小于最小容量，这将最小容量赋值给最小容量
            if (newCapacity - minCapacity < 0){
                newCapacity = minCapacity;
            }
            //创建新数组
            Object[] objects = new Object[newCapacity];
            //拷贝旧数据
            System.arraycopy(elementData,0,objects,0,elementData.length);
            //修改引用
            elementData = objects;
        }
    }
}
