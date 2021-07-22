package TestThread.com.ruan.test06;

/**
 * @PackgeName: TestThread.com.ruan.test06
 * @ClassName: Test
 * @Author: 小天才
 * Date: 2021/7/2 18:46
 * project name: Data-structure-and-algorithm
 * @Version: 0.0.1
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        Product product = new Product();
        ProducerThread producerThread = new ProducerThread(product);
        CustomerThread customerThread = new CustomerThread(product);
        producerThread.start();
        customerThread.start();
    }
}
