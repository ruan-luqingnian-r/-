package 练习.java1010;

/**
 * @Author: ruan
 * Date: 2021/10/10 9:41
 * @Description: 设计简单的可重入锁
 */
public class MyReentryLock {
    /**
     * 标识位-锁状态
     */
    private boolean isLock = false;
    /**
     * 持锁线程
     */
    private Thread lockOrder = null;
    /**
     * 加锁次数
     */
    private int codCount = 0;

    /**
     * 加锁
     */
    public synchronized void lock(){
        //获取持锁线程
    }
}
