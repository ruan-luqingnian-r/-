package 练习.java1027;

/**
 * @Author: ruan
 * Date: 2021/10/29 11:58
 * @Description:
 */
public class MyReentrantLock {
    /**
     * 锁状态
     */
    private boolean isLock = false;
    /**
     * 加锁次数
     */
    private int comCount = 0;
    /**
     * 持锁线程
     */
    private Thread lockOrder;

    /**
     * 加锁
     */
    public synchronized void lock(){
        System.out.println("开始加锁..");
        //获取当前线程
        Thread thread = Thread.currentThread();
        while (isLock && thread != lockOrder){
            System.out.println("锁被占用,挂起等待！");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        comCount++;
        lockOrder = thread;
        isLock = true;
        System.out.println("加锁完成！");
    }

    /**
     * 解锁
     */
    public synchronized void unLock(){
        System.out.println("开始解锁..");
        //获取当前线程
        Thread thread = Thread.currentThread();
        while (thread == lockOrder){
            System.out.println("开始解锁");
            comCount--;
            if (comCount == 0){
                isLock = false;
                lockOrder = null;
                System.out.println("解锁完成");
                notify();
            }
        }
    }
}
