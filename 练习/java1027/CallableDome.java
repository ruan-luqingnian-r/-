package 练习.java1027;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Author: ruan
 * Date: 2021/10/29 10:11
 * @Description: 通过Callable和FutureTask方式创建线程
 */
public class CallableDome implements Callable {
    /**
     * 1.实现Callable接口
     * 2.重写call方法
     * 3.结合FutureTask类包装Callable对象
     */
    @Override
    public Object call() throws Exception {
        System.out.println("通过Callable和FutureTask方式创建线程" + Thread.currentThread().getName());
        return "这里是返回值";
    }

    public static void main(String[] args) {
        //创建实例
        CallableDome callableDome = new CallableDome();
        //结合FutureTask类包装
        FutureTask<Object> futureTask = new FutureTask<Object>(callableDome);
        //创建线程
        Thread thread = new Thread(futureTask);
        thread.setName("Callable");
        thread.start();
    }
}
