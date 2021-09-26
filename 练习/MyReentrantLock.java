package 练习;

/**
 * @Author: ruan
 * Date: 2021/9/26 13:56
 * @Description: 简单的可重入锁
 */
public class MyReentrantLock {

    /**
     * 加锁状态
     */
    private boolean isLock = false;
    /**
     * 记录加锁次数
     */
    private int count = 0;
    /**
     * 持锁线程
     */
    private Thread lockOrder = null;

    /**
     * 加锁
     */
    public synchronized void lock(){
        System.out.println("进入加锁");
        //获取当前线程
        Thread thread = Thread.currentThread();
        //判断加锁状态与是否是同个线程加锁
        while (isLock && thread != lockOrder){
            System.out.println("进入等待状态");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //进行加锁
        isLock = true;
        lockOrder = thread;
        count++;
    }

    /**
     * 解锁
     */
    public synchronized void unlock(){
        System.out.println("开始解锁");
        //获取当前线程
        Thread thread = Thread.currentThread();
        if (lockOrder == thread){
            count--;
            if (count == 0){
                //解锁完成
                isLock = false;
                lockOrder = null;
                notify();
            }
        }
    }


}
