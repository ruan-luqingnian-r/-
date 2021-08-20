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

    /**
     * 通过下标获取对象
     */
    public Object get(int index){
        rangeCheck(index);
        return elementData[index];
    }


    /**
     * 检查下标索引是否越界
     * @param index
     */
    private void rangeCheck(int index) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("索引越界");
        }
    }

    /**
     * 判断对象所在的位置
     */
    public int indexOf(Object o){
        if (o == null){
            for (int i = 0;i < size;i++){
                if (elementData[i] == null){
                    return i;
                }
            }
        }else {
            for (int i = 0;i < size;i++){
                if (elementData[i] == o){
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 根据索引修改
     * @param index
     * @param obj
     * @return
     */
    public Object set(int index,Object obj){
        rangeCheck(index);
        Object oldValue = elementData[index];
        elementData[index] = obj;
        return oldValue;
    }

    /**
     * 根据删除索引元素
     * @param index
     * @return
     */
    public Object remove(int index){
        rangeCheck(index);
        Object oldValue = elementData[index];
        //计算要删除的位置后面还有几个元素
        int numMoved = size - index - 1;
        if (numMoved > 0){
            System.arraycopy(elementData,index + 1,elementData,index,numMoved);
        }
        elementData[--size] = null;
        return oldValue;
    }

    /**
     * 获取数组大小
     * @return
     */
    public int size(){
        return this.size;
    }
}
