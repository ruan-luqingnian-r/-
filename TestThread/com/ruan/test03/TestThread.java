package TestThread.com.ruan.test03;

/**
 * @PackgeName: TestThread.com.ruan.test03
 * @ClassName: TestThread
 * @Author: 小天才
 * Date: 2021/6/30 9:52
 * project name: Data-structure-and-algorithm
 * @Version: 0.0.1
 * @Description:
 */
public class TestThread implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i <= 10 ; i++) {
            System.out.println(Thread.currentThread().getName()+"---"+i);
        }
    }
}
