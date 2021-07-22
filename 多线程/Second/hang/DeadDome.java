package 多线程.Second.hang;

/**
 * @PackgeName: 多线程.Second.hang
 * @ClassName: DeadDome
 * @Author: 小天才
 * Date: 2021/6/28 11:18
 * project name: Data-structure-and-algorithm
 * @Version: 0.0.1
 * @Description:
 */
public class DeadDome implements Runnable{
    private static Object object = new Object();
    @Override
    public void run() {
        //持有资源
        synchronized (object){
            System.out.println(Thread.currentThread().getName()+"占用资源");
            try {
                Thread.currentThread().wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"释放资源");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new DeadDome(),"对比线程");
        thread.start();
        Thread.sleep(1000L);
        thread.notifyAll();
        Thread deadDome = new Thread(new DeadDome(),"死锁线程");
        deadDome.start();
        //Thread.sleep(3000L);
        deadDome.notifyAll();

    }
}
