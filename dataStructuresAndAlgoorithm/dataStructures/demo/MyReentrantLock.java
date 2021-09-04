package dataStructuresAndAlgoorithm.dataStructures.demo;

/**
 * @Author: ruan
 * Date: 2021/9/3 20:45
 * @Description: 可重入锁
 */
public class MyReentrantLock {

    //是否加锁标识位
    private boolean isLock = false;
    //持锁线程标记位
    private Thread lockOrder = null;
    //加锁次数
    private int lockCount = 0;

    public synchronized void lock() throws InterruptedException {
        System.out.println("进入lock加锁");
        //获取当前线程
        Thread thread = Thread.currentThread();
        //判断是否是同个线程持有
        while (isLock && lockOrder != thread){
            System.out.println("进入等待状态-当前锁状态：" + isLock);
            wait();
        }
        //进行加锁
        isLock = true;
        lockOrder = thread;
        lockCount++;
    }

    public synchronized void unlock(){
        System.out.println("进入unlock解锁");
        Thread thread = Thread.currentThread();
        if (thread == this.lockOrder){
            lockCount--;
            if (lockCount == 0){
                isLock = false;
                lockOrder = null;
                notify();
            }
        }

    }
}
