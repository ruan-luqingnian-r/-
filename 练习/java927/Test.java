package 练习.java927;

import java.util.Arrays;

/**
 * @Author: ruan
 * Date: 2021/9/27 15:14
 * @Description:
 */
public class Test {
    MyReentryLock myReentryLock = new MyReentryLock();
    public static void main(String[] args) {
        /*Test test = new Test();
        test.methodA();*/
        MyArrayList myArrayList = new MyArrayList(5);
        for (int i = 0; i < 15; i++) {
            myArrayList.add(i);
        }
        myArrayList.list();
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
    }


}
