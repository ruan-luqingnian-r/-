package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ruan
 * Date: 2021/7/7 12:59
 * @Description:
 */
public class Demo {
    volatile List lists = new ArrayList();
    public void add(Object o){
        lists.add(o);
    }
    public int size(){
        return lists.size();
    }
    public static void main(String[] args) {
        Demo demo = new Demo();
        Thread thread1 = new  Thread(() -> {
            for (int i = 0; i < 10; i++) {
                demo.add(new Object());
                System.out.println("add:" + i);
                /*try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }

        });
        Thread thread2 = new Thread(()->{
            while (true) {
                if (demo.size() == 5) {
                    break;
                }
            }
            System.out.println("end");
        });
        thread1.start();
        thread2.start();
    }
}
