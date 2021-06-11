package 多线程;

/**
 * 使用lambda表达式创建
 */
public class MyLambda {
    public static void main(String[] args) {
        new Thread(()->{
            System.out.println(Thread.currentThread().getName());
        }).start();
    }
}
