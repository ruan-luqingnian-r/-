package TestThread.com.ruan.test01;

/**
 * @PackgeName: TestThread
 * @ClassName: TestThread
 * @Author: 小天才
 * Date: 2021/6/30 9:22
 * project name: Data-structure-and-algorithm
 * @Version: 0.0.1
 * @Description:
 */
public class TestThread extends Thread {

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }

    }
}
