package 多线程.tool;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: ruan
 * Date: 2021/7/5 15:25
 * @Description:
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(8);
        new Thread(()->{
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("800m end 清空跑道");
        }).start();

        for (int i = 0; i < 8; i++) {
            int finalI = i;
            new Thread(()->{
                try {
                    Thread.sleep(finalI * 1000L);
                    System.out.println(Thread.currentThread().getName() + "到达终点");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
            }).start();
        }
    }
}
