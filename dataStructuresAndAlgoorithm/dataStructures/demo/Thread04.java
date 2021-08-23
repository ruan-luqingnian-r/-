package dataStructuresAndAlgoorithm.dataStructures.demo;

/**
 * @Author: ruan
 * Date: 2021/8/22 14:49
 * @Description:
 */
public class Thread04 implements Runnable{

    @Override
    public void run() {
        System.out.println("通过线程池创建:"+Thread.currentThread().getName());
    }
}
