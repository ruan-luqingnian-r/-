package 多线程.fourth;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: ruan
 * Date: 2021/7/3 19:43
 * @Description: 多线程debug
 */
public class DebugDemo {
    private int i = 0;
    private ReentrantLock reentrantLock = new ReentrantLock();

    public void inCreate(){
        reentrantLock.lock();
        try {
            i++;
            System.out.println(i);
        }finally {
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) {
        DebugDemo debugDemo = new DebugDemo();
        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                debugDemo.inCreate();
            }).start();
        }
    }
}
