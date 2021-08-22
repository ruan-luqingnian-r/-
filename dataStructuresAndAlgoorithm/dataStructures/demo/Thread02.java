package dataStructuresAndAlgoorithm.dataStructures.demo;

/**
 * @Author: ruan
 * Date: 2021/8/22 14:49
 * @Description:
 */
public class Thread02 implements Runnable{

    @Override
    public void run() {
        System.out.println("实现Runnable接口:"+Thread.currentThread().getName());
    }
}
