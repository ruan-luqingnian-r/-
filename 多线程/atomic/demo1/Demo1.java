package 多线程.atomic.demo1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: ruan
 * Date: 2021/7/4 12:09
 * @Description:
 */
public class Demo1 {
    private static AtomicInteger sum = new AtomicInteger(0);

    public static void inCreat(){
        sum.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 100; j++) {
                    inCreat();
                    System.out.println(sum);
                    try {
                        Thread.sleep(200l);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        }
    }
}
