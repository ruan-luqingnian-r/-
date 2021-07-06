import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: ruan
 * Date: 2021/7/6 18:43
 * @Description:
 */
public class TestReadWriteLock {

    static Lock lock = new ReentrantLock();
    static int value;

    static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    static Lock readLock = readWriteLock.readLock();
    static Lock writeLock = readWriteLock.writeLock();

    public static void read(Lock lock){
        try {
            lock.lock();
            Thread.sleep(1000);
            System.out.println("read over!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public static void write(Lock lock,int v){
        try {
            lock.lock();
            Thread.sleep(1000);
            value = v;
            System.out.println("write over!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        /*for (int i = 0; i < 10; i++) {
            new Thread(()->{
                read(lock);
            }).start();
        }
        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                write(lock,2);
            }).start();
        }*/


        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                read(readLock);
            }).start();
        }
        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                write(writeLock,2);
            }).start();
        }
    }
}
