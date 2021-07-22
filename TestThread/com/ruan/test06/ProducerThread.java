package TestThread.com.ruan.test06;

/**
 * @PackgeName: TestThread.com.ruan.test06
 * @ClassName: ProducerThread
 * @Author: 小天才
 * Date: 2021/7/2 18:13
 * project name: Data-structure-and-algorithm
 * @Version: 0.0.1
 * @Description: 生产者线程
 */
public class ProducerThread extends Thread {
    //共享商品
    private Product product;

    public ProducerThread(Product product) {
        this.product = product;
    }

    @Override
    public synchronized void run() {
        //生产10个商品
        if (product.getFlag()){
            //有商品
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 20; i++) {

                if (i % 2 == 0) {
                    product.setBrand("康师傅");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    product.setName("鲜橙汁");
                } else {
                    product.setBrand("农夫山泉");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    product.setName("水溶C100");
                }

                System.out.println("工厂生产了" + product.getBrand() + "---" + product.getName());

            //生产完了有商品了
            product.setFlag(true);
            notifyAll();//唤醒等待的消费者线程
            }
    }
}
