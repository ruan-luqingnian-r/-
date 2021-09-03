package dataStructuresAndAlgoorithm.dataStructures.demo;

/**
 * @Author: ruan
 * Date: 2021/9/3 16:02
 * @Description: 解决死锁-调整锁的范围
 *
 */
public class LockDome {
    private static String lockA = "A";
    private static String lockB = "B";

    public void methodA(){
        synchronized (lockA){
            System.out.println("我是A方法，获得锁A" + Thread.currentThread().getName());
            //让出CPU执行权，但不释放锁
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        synchronized (lockB){
            System.out.println("我是A方法，获得锁B" + Thread.currentThread().getName());
        }
    }

    public void methodB(){
        synchronized (lockB){
            System.out.println("我是B方法，获得锁B" + Thread.currentThread().getName());

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        synchronized (lockA){
            System.out.println("我是B方法，获得锁A" + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {

        System.out.println("主线程运行开始" + Thread.currentThread().getName());
        LockDome lockDome = new LockDome();

        new Thread(()->{
            lockDome.methodA();
        }).start();

        new Thread(()->{
            lockDome.methodB();
        }).start();

        System.out.println("主线程运行结束" + Thread.currentThread().getName());
    }
}
