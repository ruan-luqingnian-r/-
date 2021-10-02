package 练习.java927;

/**
 * @Author: ruan
 * Date: 2021/9/27 14:52
 * @Description:
 */
public class MyReentryLock {
    /**
     * 加锁状态
     */
    private boolean isLock = false;
    /**
     * 持锁线程
     */
    private Thread lockOrder = null;
    /**
     * 加速次数
     */
    private int modCount;

    /**
     * 加锁方法
     */
    public synchronized void lock(){
        //获取当前线程
        Thread thread = Thread.currentThread();
        System.out.println("进入加锁状态...");
        while (isLock && lockOrder != thread){
            try {
                System.out.println("进入等待...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //开始加锁
        isLock = true;
        lockOrder = thread;
        modCount++;
        System.out.println("加锁成功");
    }

    /**
     * 解锁方法
     */
    public synchronized void unlock(){
        //获取当前线程
        Thread thread = Thread.currentThread();
        System.out.println("开始解锁...");
        if (thread == lockOrder){
            modCount--;
            if (modCount == 0){
                isLock = false;
                lockOrder = null;
                System.out.println("解锁成功");
                notify();
            }
        }
    }

}
