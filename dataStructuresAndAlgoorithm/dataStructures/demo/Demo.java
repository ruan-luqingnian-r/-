package dataStructuresAndAlgoorithm.dataStructures.demo;

import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
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
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            //阻塞等待中被阻断
            e.printStackTrace();
        } catch (ExecutionException e) {
            //执行过程中发送发生异常
            e.printStackTrace();
        }
    }

}
