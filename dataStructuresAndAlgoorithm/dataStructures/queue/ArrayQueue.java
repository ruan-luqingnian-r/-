package dataStructuresAndAlgoorithm.dataStructures.queue;

/**
 * @Author: ruan
 * Date: 2021/7/21 10:03
 * @Description: 数组模拟单向队列
 * 队列特点先入先出
 */
public class ArrayQueue {

}
//
class Queue{
    private int maxSize;//数组最大值
    private int front;//声明队列头部
    private int rear;//声明队列尾部

    /**
     * 创建构造器
     */
    public Queue(int size) {
        front = -1;
        rear = -1;
        this.maxSize = size;
        int[] arr = new int[size];
    }
    /**
     * 队列相关方法
     */
    //是否满队列
    public boolean isFull(){
        return rear == maxSize - 1;
    }
    //是否空队列
    public boolean isNull(){
        return front == -1;
    }


}
