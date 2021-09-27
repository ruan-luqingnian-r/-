package 练习.java927;

/**
 * @Author: ruan
 * Date: 2021/9/27 14:52
 * @Description:
 */
public class MyReentryLock {
    /**
     * 标识位--锁状态
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
     * 加锁
     */
    public synchronized void lock(){
        System.out.println("进入加锁状态");
        //获取当前线程
        Thread thread = Thread.currentThread();
        //判断线程状态
        while (isLock && lockOrder != thread){
            System.out.println("挂起状态");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLock = true;
        lockOrder = thread;
        modCount++;
        System.out.println("加锁完成");
    }

    /**
     * 解锁
     */
    public synchronized void unlock(){
        System.out.println("进入解锁");
        //获取当前线程
        Thread thread = Thread.currentThread();
        if (lockOrder == thread){
            modCount--;
            if (modCount == 0){
                isLock = false;
                lockOrder = null;
                System.out.println("解锁成功");
            }
        }
    }
}
