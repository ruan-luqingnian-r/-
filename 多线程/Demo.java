package 多线程;

public class Demo implements Runnable {
    //重写run方法创建线程
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            System.out.println(Thread.currentThread().getName());

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Demo());
        thread.start();
        Thread.sleep(1000l);
        thread.interrupt();
    }
}
