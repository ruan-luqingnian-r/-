import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: ruan
 * Date: 2021/7/5 19:59
 * @Description:
 */
public class Test extends Thread {
    Lock lock = new ReentrantLock(true);
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "得到锁");
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        Thread thread1 = new Thread(test,"线程1");
        Thread thread2 = new Thread(test, "线程2");
        thread1.start();
        thread2.start();
    }
}
