package dataStructuresAndAlgoorithm.dataStructures.demo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: ruan
 * Date: 2021/9/3 20:45
 * @Description: 不可重入锁
 */
public class UnReentrantLock {

    private boolean isLock = false;

    public synchronized void lock(){
        System.out.println("进入加锁");
        //判断是否已经被锁，如果被锁进入等待如果没有进行加锁
        while (isLock){
            System.out.println("已经被锁进入等待");
        }
        isLock = true;
    }

    public synchronized void unlock(){
        System.out.println("解锁");
        isLock = false;
        notify();
    }
}
