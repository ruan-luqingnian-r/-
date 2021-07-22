package 多线程.container.demo2;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author: ruan
 * Date: 2021/7/5 14:14
 * @Description:
 */
public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<String> strings = new LinkedBlockingQueue<>();
        //想队列里面方元素
        strings.add("111");
        strings.offer("111");
        strings.put("111");
        //从队列里取元素
        String remove = strings.remove();
        String poll = strings.poll();
        String take = strings.take();
    }
}
