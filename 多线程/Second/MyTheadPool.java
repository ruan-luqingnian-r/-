package 多线程.Second;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @PackgeName: 多线程.Second
 * @ClassName: MyTheadPool
 * @Author: 小天才
 * Date: 2021/6/28 10:31
 * project name: Data-structure-and-algorithm
 * @Version: 0.0.1
 * @Description:
 */
public class MyTheadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(()->{
            System.out.println(Thread.currentThread().getName());
        });
    }
}
