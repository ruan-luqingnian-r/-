package 练习.java1012;

/**
 * @Author: ruan
 * Date: 2021/10/12 10:07
 * @Description:
 */
public class HungrySingleton {
    private static final HungrySingleton instance = new HungrySingleton();
    private HungrySingleton(){}
    public HungrySingleton getInstance(){
        return instance;
    }
}
