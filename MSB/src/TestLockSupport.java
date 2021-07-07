import java.util.concurrent.locks.LockSupport;

/**
 * @Author: ruan
 * Date: 2021/7/7 11:31
 * @Description:
 */
public class TestLockSupport {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                if (i == 5){
                    LockSupport.park();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        });

        thread.start();
        try {
            Thread.sleep(7000);
            System.out.println("等待7s");
            LockSupport.unpark(thread);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
