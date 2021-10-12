package 练习.java1012;

/**
 * @Author: ruan
 * Date: 2021/10/12 10:03
 * @Description:
 */
public class LazySingleton {
    private static volatile LazySingleton instance = null;
    private LazySingleton(){}
    public LazySingleton getInstance(){
        if (instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
}
