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
        System.out.println("开始加锁...");
        Thread thread = Thread.currentThread();
        while (isLock && thread != lockOrder){
            System.out.println("进入等待...");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLock = true;
        lockOrder = thread;
        codCount++;
        System.out.println("加锁完成");
    }

    /**
     * 解锁
     */
    public synchronized void unlock(){
        System.out.println("开始解锁...");
        Thread thread = Thread.currentThread();
        while (thread == lockOrder){
            System.out.println("进入解锁..");
            codCount--;
            if (codCount == 0){
                isLock = false;
                lockOrder = null;
                notify();
                System.out.println("解锁成功");
            }
        }
    }
}
