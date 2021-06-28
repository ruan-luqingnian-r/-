package 多线程.Second;

/**
 * @PackgeName: 多线程.Second
 * @ClassName: MyLambda
 * @Author: 小天才
 * Date: 2021/6/28 10:27
 * project name: Data-structure-and-algorithm
 * @Version: 0.0.1
 * @Description:
 */
public class MyLambda {
    public static void main(String[] args) {
        new Thread(()->{
            System.out.println(Thread.currentThread().getName());
        }).start();
    }
}
