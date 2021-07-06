package 多线程.communication.Demo1;

/**
 * @Author: ruan
 * Date: 2021/7/3 20:05
 * @Description:
 */
public class Demo{
    private static volatile boolean flag = false;

    public static void main(String[] args) {
        new Thread(()->{
            while (!flag){
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("flag is false");
            }
            System.out.println("flag is ture");
        }).start();


        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            flag = true;
        }).start();
    }
}
