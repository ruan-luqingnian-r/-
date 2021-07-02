package 多线程.fourth.myLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @PackgeName: 多线程.fourth.myLock
 * @ClassName: ReentryDemo
 * @Author: 小天才
 * Date: 2021/6/29 11:01
 * project name: Data-structure-and-algorithm
 * @Version: 0.0.1
 * @Description:
 */
public class ReentryDemo {
    public Lock lock = new MyLock();
    public void methodA(){
        lock.lock();
        System.out.println("进入方法A");
        methodB();
        lock.unlock();
    }
    public void methodB(){
        lock.lock();
        System.out.println("进入方法B");
        lock.unlock();
    }

    public static void main(String[] args) {
        ReentryDemo reentryDemo = new ReentryDemo();
        reentryDemo.methodA();

    }
}
