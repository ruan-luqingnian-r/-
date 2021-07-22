package 多线程.communication.Demo2;

/**
 * @Author: ruan
 * Date: 2021/7/3 21:33
 * @Description: 消费者
 */
public class Consumer implements Runnable {

    private Medium medium;
    public Consumer(Medium medium){
        this.medium = medium;
    }
    @Override
    public void run() {
        while (true){
            medium.take();
        }
    }
}
