package 多线程.communication.Demo5;

/**
 * @Author: ruan
 * Date: 2021/7/4 9:35
 * @Description:
 */
public class ThreadLocalDemo {
    ThreadLocal<Integer> num = ThreadLocal.withInitial(() -> 0);
    /**
     * creat()方法对num的值进行自增操作
     * 并输出
     */
    public void creat(){
        Integer myNum = num.get();
        myNum++;
        System.out.println(Thread.currentThread().getName() + "-------->" + myNum);
        num.set(myNum);
    }

    public static void main(String[] args) {
        ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo();
        for (int i = 1; i < 3; i++) {
            int finalI = i;
            new Thread(()->{
                while (true) {
                    threadLocalDemo.creat();
                    try {
                        Thread.sleep(finalI * 1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
