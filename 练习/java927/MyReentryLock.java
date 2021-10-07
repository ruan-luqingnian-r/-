package 练习.java927;

/**
 * @Author: ruan
 * Date: 2021/9/27 14:52
 * @Description:
 */
public class MyReentryLock {
    /**
     * 标记位-锁状态
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

    public synchronized void lock(){
        System.out.println("开始加锁..");
        //获取持锁线程
        Thread thread = Thread.currentThread();
        //判断是否是同一线程
        while (isLock && lockOrder != thread){
            System.out.println("进入等待..");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //加锁
        isLock = true;
        lockOrder = thread;
        codCount++;
        System.out.println("加锁完成");
    }

    public synchronized void unlock(){
        System.out.println("开始解锁..");
        //获取当前线程
        Thread thread = Thread.currentThread();
        if (lockOrder == thread){
            codCount--;
            if (codCount == 0){
                isLock = false;
                lockOrder = null;
                notify();
                System.out.println("解锁完成");
            }
        }
    }
}
