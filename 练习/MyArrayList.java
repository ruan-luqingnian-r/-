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

    /**
     * 有参构造
     * @param initialCapacity
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
     * 扩容机制
     * @param minCapacity 最小容量
     */
    public void ensureCapacityInternal(int minCapacity){
        //判断是否是第一次扩容
        if (elementData == EMPTY_ELEMENT_DATA){
            //如果是第一次扩容，使用默认容量或者最小容量
            minCapacity = Math.max(DEFAULT_CAPACITY,minCapacity);
        }
        //如果不是第一次扩容，判断是否需要扩容
        if (elementData.length - minCapacity < 0){
            //需要扩容
            int oldCapacity = elementData.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            //比较扩容出来的值和最小值的大小
            if (newCapacity - minCapacity < 0){
                newCapacity = minCapacity;
            }
            //创建新数组
            Object[] objects = new Object[newCapacity];
            //拷贝数据
            System.arraycopy(elementData,0,objects,0,size);
            //修改引用
            elementData = objects;
        }
    }

    /**
     * 检查下标是否越界
     * @param index 数组下标
     */
    public void rangeCheck(int index){
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("下标越界");
        }
    }

    /**
     * 添加数据
     * @param o 待添加数据
     * @return
     */
    public boolean add(Object o){
        //并发判断
        modCount++;
        //容量判断
        ensureCapacityInternal(size + 1);
        //插入数据
        elementData[size++] = o;
        return true;
    }

    /**
     * 根据下标获取数据
     * @param index 数组下标
     * @return
     */
    public Object get(int index){
        //下标检查
        rangeCheck(index);
        return elementData[index];
    }

    /**
     * 根据对象获取下标
     * @param o 对象
     * @return 下标
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
                if (elementData[i] == null){
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 根据下标修改对象
     * @param index 要修改的下标
     * @param o 新值
     * @return 旧值
     */
    public Object set(int index,Object o){
        //并发判断
        modCount++;
        //检查下标
        rangeCheck(index);
        Object odlValue = elementData[index];
        elementData[index] = o;
        return odlValue;
    }

    /**
     * 根据下标删除索引
     * @param index 下标
     * @return 删除的值
     */
    public Object remove(int index){
        //并发判断
        modCount++;
        //检查下标
        rangeCheck(index);
        Object odlValue = elementData[index];
        //计算待删除的下标后还有多少元素
        int munMove = size - index - 1;
        if (munMove > 0){
            //移动数据
            System.arraycopy(elementData,index + 1,elementData,index,munMove);
        }
        //末位置空
        elementData[--size] = null;
        return odlValue;
    }

    /**
     * 获取数组大小
     * @return 数组大小
     */
    public int size(){
        return this.size;
    }
}
