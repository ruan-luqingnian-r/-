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
    private  int[] arr;
    /**
     * 创建构造器
     */
    public Queue(int size) {
        front = -1;
        rear = -1;
        this.maxSize = size;
        arr = new int[size];
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
    //入队列
    public void add(int number){
        //首先判断是否满
        if (isFull()){
            System.out.println("队列已满，无法入队");
            return;
        }
        //如果未满则开始入队
        rear++;
        arr[rear] = number;
    }
    //查看队头（不出队列）
    public int get(){
        //先判断队列是否为空
        if (isNull()){
            System.out.println("队列为空，无数据");
        }
        return arr[front + 1];
    }
    //弹出队列头部数据
    public int pop(){
        //先判断队列是否为空
        if (isNull()){
            System.out.println("队列为空，无数据");
        }
        front++;
        return arr[front];
    }
    //遍历队列
    public void list(){
        //先判断队列是否为空
        if (isNull()){
            System.out.println("队列为空，无数据");
            return;
        }

    }


}
