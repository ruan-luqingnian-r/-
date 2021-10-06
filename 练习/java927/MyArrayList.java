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




}
