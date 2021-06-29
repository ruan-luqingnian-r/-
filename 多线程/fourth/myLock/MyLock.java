package 多线程.fourth.myLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @PackgeName: 多线程.fourth.myLock
 * @ClassName: MyLock
 * @Author: 小天才
 * Date: 2021/6/29 10:41
 * project name: Data-structure-and-algorithm
 * @Version: 0.0.1
 * @Description:
 */
public class MyLock implements Lock {
    //是否持有锁
    private boolean isHoldLock = false;
    private Thread holdLockThread = null;
    private int holeLockCount = 0;
    /**
     * 同一时刻，有且仅能有一个线程获取到锁，其他线程只能等他释放锁之后才能获取到锁
     */
    @Override
    public synchronized void lock() {
        if (isHoldLock && Thread.currentThread() != holdLockThread){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        holdLockThread = Thread.currentThread();
        isHoldLock = true;
        holeLockCount++;
    }

    @Override
    public synchronized void unlock() {
        //判断是否是持有锁的线程
        if (Thread.currentThread() == holdLockThread){

            holeLockCount--;
        }
        if (holeLockCount == 0) {
            notify();
            isHoldLock = false;
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
