package 多线程.communication.Demo1;

/**
 * @Author: ruan
 * Date: 2021/7/3 20:05
 * @Description:
 */
public class Demo1 {
    private static volatile boolean flag = false;

    public static void main(String[] args) {
        Object object = new Object();
        new Thread(()->{
            while (!flag){
                synchronized (object){
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("flag is false");
                }
                System.out.println("flag is ture");
                }
        }).start();

         
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            flag = true;
            synchronized (object){
                object.notify();
            }
        }).start();
    }
}
