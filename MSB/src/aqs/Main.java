package aqs;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: ruan
 * Date: 2021/7/7 15:21
 * @Description:
 */
public class Main {
    private static volatile  int i = 0;

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();
    }
}
