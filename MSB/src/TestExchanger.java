import java.util.concurrent.Exchanger;

/**
 * @Author: ruan
 * Date: 2021/7/6 20:36
 * @Description: 数据交换
 */
public class TestExchanger {
    public static void main(String[] args) {
        Exchanger<String> stringExchanger = new Exchanger<>();

        new Thread(()->{
            String T1 = "t1";
            try {
                String exchange = stringExchanger.exchange(T1);
                System.out.println(Thread.currentThread().getName() + ":" + exchange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T1").start();
        new Thread(()->{
            String T2 = "t2";
            try {
                String exchange = stringExchanger.exchange(T2);
                System.out.println(Thread.currentThread().getName() + ":" + exchange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T2").start();
    }
}
