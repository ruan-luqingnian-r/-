package 多线程.pool;

import com.sun.corba.se.spi.orbutil.threadpool.ThreadPool;

import java.util.concurrent.*;

/**
 * @Author: ruan
 * Date: 2021/7/5 16:05
 * @Description: 线程池Demo
 */
public class ThreadPoolDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        LinkedBlockingQueue<Runnable> runnables = new LinkedBlockingQueue<>();
      /*for (int i = 0; i < 100; i++) {
            runnables.put(()->{
                System.out.println(Thread.currentThread().getName());
            });
        }*/
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 3, TimeUnit.SECONDS, runnables);
        Future<String> submit = null;
        for (int i = 0; i < 30; i++) {
             threadPoolExecutor.submit(()->{
                 try {
                     Thread.sleep(2000);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                 System.out.println(threadPoolExecutor.getActiveCount());
             });
        }
        /*for (int i = 0; i < 100; i++) {
            System.out.println(submit.get());
        }*/
        //threadPoolExecutor.prestartAllCoreThreads();

    }
}
