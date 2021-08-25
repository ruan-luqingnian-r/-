package dataStructuresAndAlgoorithm.dataStructures.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: ruan
 * Date: 2021/8/25 15:09
 * @Description:
 */
public class ThreadTest {
    private int num = 0;
    //使用lock，每个对象都是有锁的，只有获得这个锁才可以进行对应从操作
    Lock lock = new ReentrantLock();
    public void add(){
        lock.lock();
        try {
            num++;
        }finally {
            lock.unlock();
        }
    }

    //使用synchronized，和上述是同一个操作，这个是保证方法被锁住
    public synchronized void add2(){
        num++;
    }
}
