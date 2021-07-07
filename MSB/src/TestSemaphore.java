import java.util.concurrent.Semaphore;

/**
 * @Author: ruan
 * Date: 2021/7/6 20:01
 * @Description: 信号量
 */
public class TestSemaphore {
    public static void main(String[] args) {
        //允许两个线程同时进行
        Semaphore semaphore = new Semaphore(2);
        new Thread(()->{
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + "start");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                semaphore.release();
            }
        }).start();
        new Thread(()->{
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + "start");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                semaphore.release();
            }
        }).start();
        new Thread(()->{
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + "start");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                semaphore.release();
            }
        }).start();
    }
}
