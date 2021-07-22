package TestThread.com.ruan.test04;

/**
 * @PackgeName: TestThread.com.ruan.test04
 * @ClassName: test
 * @Author: 小天才
 * Date: 2021/6/30 10:20
 * project name: Data-structure-and-algorithm
 * @Version: 0.0.1
 * @Description:
 */
public class test {
    public static void main(String[] args) {
        BuyTicketThread buyTicketThread = new BuyTicketThread();
        Thread thread1 = new Thread(buyTicketThread,"1");
        Thread thread2 = new Thread(buyTicketThread,"2");
        Thread thread3 = new Thread(buyTicketThread,"3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
