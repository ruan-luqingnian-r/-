package TestThread.com.ruan.test03;

/**
 * @PackgeName: TestThread.com.ruan.test03
 * @ClassName: test
 * @Author: 小天才
 * Date: 2021/6/30 9:55
 * project name: Data-structure-and-algorithm
 * @Version: 0.0.1
 * @Description:
 */
public class test {
    public static void main(String[] args) {
        TestThread tt = new TestThread();
        Thread thread = new Thread(tt,"子线程");
        thread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"---"+i);
        }
    }
}
