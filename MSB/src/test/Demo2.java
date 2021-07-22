package test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @Author: ruan
 * Date: 2021/7/7 14:58
 * @Description: 栅栏
 */
public class Demo2 {
    volatile List lists = new ArrayList();
    public void add(Object o){
        lists.add(o);
    }
    public int size(){
        return lists.size();
    }
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Demo2 demo2 = new Demo2();
        new Thread(()->{
                if (demo2.size() != 5){
                    countDownLatch.countDown();
                    System.out.println("end");
                    countDownLatch.countDown();
                }

        }).start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                demo2.add(new Object());
                System.out.println("add:" + i);
                if (demo2.size() == 5){
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                /*try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
        }).start();

    }
}
