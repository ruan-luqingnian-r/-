package dataStructuresAndAlgoorithm.dataStructures.demo;

import java.util.concurrent.Callable;

/**
 * @Author: ruan
 * Date: 2021/8/23 15:51
 * @Description:
 */
public class MyTask implements Callable<Object> {
    @Override
    public Object call() throws Exception {
        System.out.println("实现Callable接口:"+Thread.currentThread().getName());
        return "这个是返回值";
    }
}
