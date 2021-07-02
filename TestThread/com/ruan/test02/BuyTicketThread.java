package TestThread.com.ruan.test02;

/**
 * @PackgeName: TestThread.com.ruan.test02
 * @ClassName: BuyTicketThread
 * @Author: 小天才
 * Date: 2021/6/30 9:40
 * project name: Data-structure-and-algorithm
 * @Version: 0.0.1
 * @Description:
 */
public class BuyTicketThread extends Thread{
    static int ticketNumber = 10;//多对象共享
    //每个人线程对象执行的代码放在run方法中
    public BuyTicketThread(String name){
        super(name);
    }
    @Override
    public void run() {


        for (int i = 1; i <= 100; i++) {
            if (ticketNumber > 0){
                System.out.println("我在"+this.getName()+"窗口买到了第"+ticketNumber--+"张车票");
            }
        }
    }
}
