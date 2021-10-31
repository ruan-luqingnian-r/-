package 练习.java1027;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: ruan
 * Date: 2021/10/29 10:25
 * @Description: 线程池创建线程
 */
public class ExecutorsDemo implements Runnable {
    @Override
    public void run() {
        System.out.println("通过线程池创建:"+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            pool.execute(new ExecutorsDemo());
        }
        pool.shutdown();
    }
}
