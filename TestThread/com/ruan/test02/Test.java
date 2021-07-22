package TestThread.com.ruan.test02;

/**
 * @PackgeName: TestThread.com.ruan.test02
 * @ClassName: test
 * @Author: 小天才
 * Date: 2021/6/30 9:43
 * project name: Data-structure-and-algorithm
 * @Version: 0.0.1
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        BuyTicketThread t1 = new BuyTicketThread("窗口1");
        BuyTicketThread t2 = new BuyTicketThread("窗口2");
        BuyTicketThread t3 = new BuyTicketThread("窗口3");
        t1.start();
        t2.start();
        t3.start();

    }


}
