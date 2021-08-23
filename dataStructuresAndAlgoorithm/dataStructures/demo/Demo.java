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
        Thread thread = new Thread(()->{
            System.out.println("使用匿名内部类实现多线程:"+Thread.currentThread().getName());
        });

        thread.setName("Thread03");
        thread.start();
    }

}
