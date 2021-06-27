package 多线程;

/**
 * @PackgeName: 多线程
 * @ClassName: test
 * @Author: 小天才
 * Date: 2021/6/27 18:42
 * project name: Data-structure-and-algorithm
 * @Version: 0.0.1
 * @Description:
 */
public class test {
    //死锁
    private static final Object HAIR_A = new Object();
    private static final Object HAIR_B = new Object();

    public static void main(String[] args) {
        new Thread(()->{
           synchronized (HAIR_A){
               synchronized (HAIR_B){
                   System.out.println("A成功的薅到B的头发");
               }
           }
        }).start();
    }
}
