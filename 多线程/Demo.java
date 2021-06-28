package 多线程;

import java.io.IOException;

public class Demo{
    public static void main(String[] args) throws IOException, InterruptedException {
//        Thread thread = new Thread(()->{
//            try {
//                System.in.read();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
//        thread.start();
//        Object obj = new Object();
//        Thread thread = new Thread(()->{
//            synchronized (obj){
//                try {
//                    Thread.sleep(12321321312L);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        thread.start();
//        Thread.sleep(2000L);
//        Thread thread2 = new Thread(()->{
//            synchronized (obj){
//            }
//        });
//        thread2.start();

        Object obj = new Object();
        Thread thread = new Thread(()->{
            synchronized (obj){
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}
