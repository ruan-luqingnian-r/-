package 练习.java1011;

/**
 * @Author: ruan
 * Date: 2021/10/11 9:24
 * @Description: 单例模式-饿汉式
 */
public class HungrySingleton {
    //程序运行时则自动创建
    private static final HungrySingleton instance = new HungrySingleton();
    //私有话构造方法
    private HungrySingleton(){}
    public static HungrySingleton getInstance(){
        return instance;
    }
}
