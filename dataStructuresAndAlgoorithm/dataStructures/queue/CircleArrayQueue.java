package dataStructuresAndAlgoorithm.dataStructures.queue;

/**
 * @Author: ruan
 * Date: 2021/7/21 11:22
 * @Description: 环形（可重复使用）基于数组的模拟队列
 */
public class CircleArrayQueue {
}
class CircleQueue{
    private int maxSize;//队列最大容量
    private int[] arr;
    private int front;//队头
    private int rear;//队尾

    /**
     * 构造器
     */
    public CircleQueue(int size){
        maxSize = size;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    /**
     * 相关方法
     */
    //队列是否为空
    public boolean isNull(){
        return front == rear;
    }
    //队列是否满
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }
    //向队列中添加数据
    public void add(int number){
        //先判断是否已满
        if (isFull()){
            System.out.println("队列已满无法入队");
            return;
        }
        arr[rear] = number;
        rear = (rear + 1) % maxSize;//队尾后移
    }
    //获取队头数据
    public int get(){
        //判断是否为空
        if (isNull()){
            System.out.println("队列中数据为空");
        }
        return arr[front];
    }
    //出队列
    public int pop(){
        //判断是否为空
        if (isNull()){
            System.out.println("队列中数据为空");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }
    //显示队列所有数据
    public void showQueue() {
        if (isNull()) {
            System.out.println("队列为空");
        } else {
            for (int i = front; i < front + size(); i++) {
                System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
            }
        }
    }

    //队列大小
    public int size(){
        return (rear - front + maxSize) % maxSize;
    }


}

