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
    private Thread lockOrder = null;

    /**
     * 加锁次数
     */
    private int modCount = 0;

    /**
     * 加锁方法
     */
    public synchronized void lock(){
        System.out.println("开始加锁...");
        //获取当前线程
        Thread thread = Thread.currentThread();
        while (isLock && lockOrder != thread){
            System.out.println("进入等待");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLock = true;
        lockOrder = thread;
        modCount++;
        System.out.println("加锁成功");
    }



}
