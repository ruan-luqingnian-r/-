package 练习.java927;

/**
 * @Author: ruan
 * Date: 2021/9/27 14:52
 * @Description:
 */
public class MyReentryLock {

    /**
     * 标记位-上锁状态
     */
    private boolean isLock = false;

    /**
     * 持锁线程
     */
    private Thread thread = null;

    /**
     * 加锁次数
     */
    private int modCount = 0;




}
