package 多线程.Second.interrupt;

import 多线程.Second.hang.DeadDome;

/**
 * @PackgeName: 多线程.Second.interrupt
 * @ClassName: Dome
 * @Author: 小天才
 * Date: 2021/6/28 11:54
 * project name: Data-structure-and-algorithm
 * @Version: 0.0.1
 * @Description:
 */
public class Dome extends Thread{

    int i = 0;
    int j = 0;
    @Override
    public void run() {
        i++;
        try {
            sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        j++;
    }
    public void printf(){
        System.out.println("j=======>"+j);
        System.out.println("i=======>"+i);
    }

    public static void main(String[] args) throws InterruptedException {
        Dome dome = new Dome();
        dome.start();
        Thread.sleep(1000L);
        dome.interrupt();
        dome.printf();

    }
}
