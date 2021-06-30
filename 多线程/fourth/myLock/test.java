package 多线程.fourth.myLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @PackgeName: 多线程.fourth.myLock
 * @ClassName: test
 * @Author: 小天才
 * Date: 2021/6/29 16:36
 * project name: Data-structure-and-algorithm
 * @Version: 0.0.1
 * @Description:
 */
public class test {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        reentrantLock.unlock();
    }
}
