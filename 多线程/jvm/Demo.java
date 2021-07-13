package 多线程.jvm;

/**
 * @Author: ruan
 * Date: 2021/7/8 14:30
 * @Description:
 */
public class Demo{
    static int x = 0,y = 0,a = 0,b = 0;
    static int i = 0;
    static boolean flag = true;
    public static void main(String[] args) throws InterruptedException {


        while (flag) {
            Thread thread = new Thread(() -> {
                a = 1;
                x = b;
            });
            Thread thread1 = new Thread(() -> {
                b = 1;
                y = a;
            });
            i++;
            thread.start();
            thread1.start();
            thread.join();
            thread.join();
            System.out.println("第"+ i + "次"+"x ======> " + x + "     y ======> " + y);
            if (x == 0 && y == 0){
                flag = false;
            }else {
                x = 0;
                y = 0;
                a = 0;
                b = 0;
            }
        }


    }
}
