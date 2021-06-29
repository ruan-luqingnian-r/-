package 多线程.third;

import java.util.concurrent.CountDownLatch;

/**
 * @PackgeName: 多线程.frist
 * @ClassName: UnSafeThread
 * @Author: 小天才
 * Date: 2021/6/27 19:09
 * project name: Data-structure-and-algorithm
 * @Version: 0.0.1
 * @Description:
 */
public class UnSafeThread {

    private static int num = 0;
    private static CountDownLatch countDownLatch = new CountDownLatch(10);

    /**
     * 每次调用对num进行++操作
     */
    public static synchronized void inCreate(){
        num++;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 100; j++) {
                    inCreate();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                countDownLatch.countDown();
            }).start();
        }
        while (true){
            if (countDownLatch.getCount() == 0){
                System.out.println(num);
                break;
            }
        }

    }
}
