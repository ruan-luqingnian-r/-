package 多线程.container.demo2;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: ruan
 * Date: 2021/7/5 7:37
 * @Description:
 */
public class Demo {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> strings = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 1000; i++) {
            strings.add("demo" + i);
        }
//        strings.forEach(e->{
//            if (e.equals("demo3")){
//                strings.remove(e);
//            }
//            System.out.println(e);
//        });
//        Iterator<String> iterator = strings.iterator();
//        while (iterator.hasNext()){
//            String next = iterator.next();
////            System.out.println(next);
////            if (next.equals("demo2")){
////                iterator.remove();
////            }
//        }
        for (int i = 0; i < 4; i++) {
            new Thread(()->{
                strings.forEach(e->{
                    if (e.equals("demo2")){
                        strings.remove(e);
                    }
                });
            }).start();
        }
    }
}
