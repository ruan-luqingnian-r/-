package dataStructuresAndAlgoorithm.dataStructures.demo;

import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: ruan
 * Date: 2021/8/17 10:38
 * @Description:
 */
public class Demo {

    public static void main(String[] args) {
        Thread02 thread02 = new Thread02();
        Thread thread = new Thread(thread02);
        thread.setName("Dome2");
        thread.start();

        System.out.println("主线程名称:"+Thread.currentThread().getName());
    }

}
