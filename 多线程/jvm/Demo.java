package 多线程.jvm;

/**
 * @Author: ruan
 * Date: 2021/7/8 14:30
 * @Description:
 */
public class Demo{
    static int x = 0,y = 0,a = 0,b = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            a = 1;
            x = b;
        });
        Thread thread1 = new Thread(() -> {
            b = 1;
            y = a;
        });

        thread.start();
        thread1.start();
        thread.join();
        thread.join();

        System.out.println("x ======> " + x + "     y ======> " + y);
    }
}
