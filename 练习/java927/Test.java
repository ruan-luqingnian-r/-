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
    }


}
