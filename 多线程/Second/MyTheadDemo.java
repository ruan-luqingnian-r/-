package 多线程.Second;

/**
 * @PackgeName: 多线程.Second
 * @ClassName: MyTheadDemo
 * @Author: 小天才
 * Date: 2021/6/28 10:24
 * project name: Data-structure-and-algorithm
 * @Version: 0.0.1
 * @Description:
 */
public class MyTheadDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        thread.start();
    }
}
