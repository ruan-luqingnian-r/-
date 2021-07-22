package TestThread.com.ruan.test01;

/**
 * @PackgeName: TestThread.com.ruan.test01
 * @ClassName: test
 * @Author: 小天才
 * Date: 2021/6/30 9:26
 * project name: Data-structure-and-algorithm
 * @Version: 0.0.1
 * @Description: 测试类
 */
public class test {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println("main1---"+i);
        }
        TestThread tt = new TestThread();//具体的线程对象
        //tt.run();//run方法不能直接调用，直接调用的话会被当作普通方法

        tt.start();//start方法是父类的方法
        for (int i = 1; i <= 10; i++) {
            System.out.println("main2---"+i);
        }
    }
}
