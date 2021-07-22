package 多线程.Second.hang;

/**
 * @PackgeName: 多线程.Second.hang
 * @ClassName: SuspendDome
 * @Author: 小天才
 * Date: 2021/6/28 11:08
 * project name: Data-structure-and-algorithm
 * @Version: 0.0.1
 * @Description:
 */
public class SuspendDome implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"执行run()，准备调用suspended()");
        Thread.currentThread().suspend();
        System.out.println(Thread.currentThread().getName()+"执行run()，调用suspended()结束");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new SuspendDome());
        thread.start();
        Thread.sleep(3000L);
        thread.resume();
    }
}
