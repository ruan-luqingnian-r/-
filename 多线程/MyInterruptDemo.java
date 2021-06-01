package 多线程;

public class MyInterruptDemo implements Runnable {
    private static volatile boolean FLAG = true;
    @Override
    public void run() {
        while (FLAG){
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyInterruptDemo());
        Thread.sleep(2000l);
        thread.start();
        FLAG = false;
    }
}
