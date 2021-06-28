package 多线程.Second;

/**
 * @PackgeName: 多线程.Second
 * @ClassName: MyThread
 * @Author: 小天才
 * Date: 2021/6/28 10:01
 * project name: Data-structure-and-algorithm
 * @Version: 0.0.1
 * @Description:
 */
public class MyThread extends Thread{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.setName("线程demo");
        myThread.start();
    }
}
