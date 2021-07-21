package dataStructuresAndAlgoorithm.dataStructures.queue;

import java.util.Scanner;

/**
 * @Author: ruan
 * Date: 2021/7/21 11:22
 * @Description: 环形（可重复使用）基于数组的模拟队列
 */
public class CircleArrayQueue {

    public static void main(String[] args) {
        boolean loop = true;
        CircleQueue queue = new CircleQueue(4);//队列实际存储大小为4-1(约定空间)
        Scanner scanner = new Scanner(System.in);
        char key;
        //弹出菜单
        while (loop){
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            System.out.print("请操作：");
            key = scanner.next().charAt(0);
            switch (key){
                case 's' : queue.showQueue();
                    break;
                case 'e' :
                    System.out.println("==退出程序==");
                    loop = false;
                    break;
                case 'a' :
                    System.out.print("请输入:");
                    int value = scanner.nextInt();
                    queue.add(value);
                    break;
                case 'g' : int i = queue.pop();
                    System.out.println("===取出的数据是===");
                    System.out.println(i);
                    break;
                case 'h' : int j = queue.get();
                    System.out.println("===对头的数据是===");
                    System.out.println(j);
                    break;
            }
        }

    }
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

