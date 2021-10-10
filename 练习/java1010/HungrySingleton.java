package 练习.java1010;

/**
 * @Author: ruan
 * Date: 2021/10/10 10:15
 * @Description: 单例模式-饿汉式
 */
public class HungrySingleton {
    private static final HungrySingleton instance = new HungrySingleton();
    private HungrySingleton(){}
    public static HungrySingleton getInstance(){
        return instance;
    }
}
