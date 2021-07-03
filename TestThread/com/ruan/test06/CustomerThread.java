package TestThread.com.ruan.test06;

/**
 * @PackgeName: TestThread.com.ruan.test06
 * @ClassName: CustomerThread
 * @Author: 小天才
 * Date: 2021/7/2 18:44
 * project name: Data-structure-and-algorithm
 * @Version: 0.0.1
 * @Description: 消费者线程
 */
public class CustomerThread extends Thread{
    //共享商品
    private Product product;

    public CustomerThread(Product product) {
        this.product = product;
    }

    @Override
    public synchronized void run() {

            if (!product.getFlag()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < 10; i++) {
                System.out.println("消费者消费了：" + product.getBrand() + "---" + product.getName());
                product.setFlag(false);
                notifyAll();
            }

    }
}
