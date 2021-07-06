import java.util.concurrent.CountDownLatch;

/**
 * @Author: ruan
 * Date: 2021/7/6 20:42
 * @Description: 倒计时锁存器
 */
public class TestCountDownLatch {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread(()->{
            try {
                countDownLatch.await();
                System.out.println("计数结束——开始运行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            new Thread(()->{
                int j = finalI;
                try {
                    Thread.sleep(finalI * 1000);
                    System.out.println(Thread.currentThread().getName() + "就绪");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
            }).start();
        }
    }
}
