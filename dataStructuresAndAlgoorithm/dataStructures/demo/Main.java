package dataStructuresAndAlgoorithm.dataStructures.demo;

/**
 * @Author: ruan
 * Date: 2021/9/4 8:06
 * @Description:
 */
public class Main {

    private UnReentrantLock unReentrantLock = new UnReentrantLock();

    public void methodA(){

        try {
            unReentrantLock.lock();
            System.out.println("methodA被调用");
            methodB();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            unReentrantLock.unlock();
        }
    }

    public void methodB(){

        try {
            unReentrantLock.lock();
            System.out.println("methodB被调用");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            unReentrantLock.unlock();
        }
    }
}
