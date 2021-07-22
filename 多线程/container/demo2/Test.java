package 多线程.container.demo2;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author: ruan
 * Date: 2021/7/5 10:21
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        LinkedBlockingDeque<String> strings = new LinkedBlockingDeque<>();
        for (int i = 0; i < 10000; i++) {
            strings.add("demo" + i);
        }
        System.out.println(strings.toString());

    }
}
