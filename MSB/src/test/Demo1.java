package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ruan
 * Date: 2021/7/7 14:28
 * @Description:
 */
public class Demo1 {
    volatile List lists = new ArrayList();
    public void add(Object o){
        lists.add(o);
    }
    public int size(){
        return lists.size();
    }

    public static void main(String[] args) throws InterruptedException {
        Demo1 demo1 = new Demo1();
        Thread thread = new Thread(() -> {
            synchronized (demo1.lists) {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    demo1.add(new Object());
                    System.out.println(i);
                    if (i == 5) {

                    }
                }
            }
        });
        Thread thread1 = new Thread(()->{
            synchronized (demo1.lists){
                if (demo1.size() == 5){
                    System.out.println("out");
                }
            }
        });
        thread.start();
        thread1.join();
        thread1.start();
    }
}
