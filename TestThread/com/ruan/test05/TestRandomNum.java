package TestThread.com.ruan.test05;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @PackgeName: TestThread.com.ruan.test05
 * @ClassName: TestRandomNum
 * @Author: 小天才
 * Date: 2021/6/30 10:33
 * project name: Data-structure-and-algorithm
 * @Version: 0.0.1
 * @Description:
 */
public class TestRandomNum implements Callable<Integer> {

    /**
     * 实现callable接口可以不带泛型
     * @return
     * @throws Exception
     */
    @Override
    public Integer call() throws Exception {
        return new Random().nextInt(10);
    }
}
class Test{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestRandomNum tt = new TestRandomNum();
        FutureTask futureTask = new FutureTask(tt);
        Thread thread = new Thread(futureTask);
        thread.start();
        Object o = futureTask.get();
        System.out.println(o);
    }
}
