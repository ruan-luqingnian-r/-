package TestThread.com.ruan.test04;

/**
 * @PackgeName: TestThread.com.ruan.test04
 * @ClassName: BuyTicketThread
 * @Author: 小天才
 * Date: 2021/6/30 10:07
 * project name: Data-structure-and-algorithm
 * @Version: 0.0.1
 * @Description:
 */
public class BuyTicketThread implements Runnable{
     int ticketNumber = 10;
    @Override
    public void run() {
        for (int i = 1; i <= 10 ; i++) {
            if (ticketNumber > 0){
                synchronized(this){
                    System.out.println("我在窗口"+Thread.currentThread().getName()+"买到了第"+ticketNumber--+"张票");
                }

            }
        }
    }
}
