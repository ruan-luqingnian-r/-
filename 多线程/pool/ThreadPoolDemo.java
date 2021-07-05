package 多线程.pool;

import com.sun.corba.se.spi.orbutil.threadpool.ThreadPool;

import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: ruan
 * Date: 2021/7/5 16:05
 * @Description: 线程池Demo
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        LinkedBlockingQueue<Runnable> runnables = new LinkedBlockingQueue<>(10);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(20,20,3000L,TimeUnit.SECONDS,runnables);

        for (int i = 0; i < 100; i++) {
            Future<?> submit = threadPoolExecutor.submit(() -> {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }
    }
}
