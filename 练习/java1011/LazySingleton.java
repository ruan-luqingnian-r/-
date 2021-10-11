package 练习.java1011;

/**
 * @Author: ruan
 * Date: 2021/10/11 9:15
 * @Description: 单例模式-懒汉式
 */
public class LazySingleton {
    //保证instance在线程中同步
    private static volatile LazySingleton instance = null;
    //私有化构造方法
    private LazySingleton(){}
    //同步方法获取实例
    public static synchronized LazySingleton getInstance(){
        if (instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
}
