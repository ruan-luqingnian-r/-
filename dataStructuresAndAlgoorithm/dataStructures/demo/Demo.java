package dataStructuresAndAlgoorithm.dataStructures.demo;

import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;

/**
 * @Author: ruan
 * Date: 2021/8/17 10:38
 * @Description:
 */
public class Demo {

    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        FutureTask<Object> futureTask = new FutureTask<>(myTask);
        Thread thread = new Thread(futureTask);
        thread.setName("dome3");
        thread.start();
    }

}
