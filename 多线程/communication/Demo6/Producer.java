package 多线程.communication.Demo6;

/**
 * @Author: ruan
 * Date: 2021/7/3 21:34
 * @Description: 生产者
 */
public class Producer implements Runnable {

    private Medium medium;

    public Producer(Medium medium){
        this.medium = medium;
    }

    @Override
    public void run() {
        while (true){
            medium.put();
        }
    }
}
