package 练习.java1010;

/**
 * @Author: ruan
 * Date: 2021/10/10 10:06
 * @Description: 单例模式-懒汉式
 */
public class LazySingleton {
    //保证instance在所有线程中同步
    private static volatile LazySingleton instance = null;
    //私有话构造方法,避免改类在外部被实例化
    private LazySingleton(){}
    //同步方法获取实例
    public static synchronized LazySingleton getInstance(){
        if (instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }

}
