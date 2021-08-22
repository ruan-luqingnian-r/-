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
        Thread01 thread01 = new Thread01();
        thread01.setName("demo01");
        thread01.start();

        System.out.println("主线程名称:"+Thread.currentThread().getName());
    }

}
