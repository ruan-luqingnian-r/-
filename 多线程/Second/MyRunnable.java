package 多线程.Second;

import java.io.IOException;

/**
 * @PackgeName: 多线程.Second
 * @ClassName: MyRunable
 * @Author: 小天才
 * Date: 2021/6/28 10:08
 * project name: Data-structure-and-algorithm
 * @Version: 0.0.1
 * @Description:
 */
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.setName("ruan");
        thread.start();
        //thread.run();
    }
}
