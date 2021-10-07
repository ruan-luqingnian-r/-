package 练习.java927;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * @Author: ruan
 * Date: 2021/9/27 15:14
 * @Description:
 */
public class Test {
    /*MyReentryLock myReentryLock = new MyReentryLock();
    public static void main(String[] args) {
        Test test = new Test();
        test.methodA();
        //System.out.println(1%2 == 1);
    }

    public void methodA(){
        try {
            myReentryLock.lock();
            System.out.println("methodA被调用");
            methodB();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            myReentryLock.unlock();
        }
    }


    public void methodB(){

        try {
            myReentryLock.lock();
            System.out.println("methodB被调用");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            myReentryLock.unlock();
        }
    }*/
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(2, "测试2");
        treeMap.put(1, "测试1");
        treeMap.put(4, "测试4");
        treeMap.put(3, "测试3");
        System.out.println(treeMap);
    }


}
