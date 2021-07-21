package dataStructuresAndAlgoorithm.dataStructures.queue;

import java.util.Scanner;

/**
 * @Author: ruan
 * Date: 2021/7/21 10:03
 * @Description: 数组模拟单向队列
 * 队列特点先入先出
 */
public class ArrayQueue {
    public static void main(String[] args) {
        //测试队列功能
        boolean loop = true;
        System.out.println("=====功能测试=====");
        Queue queue = new Queue(3);
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
                case 's' : queue.list();
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
                    System.out.println("===队头的数据是===");
                    System.out.println(j);
                    break;
            }
        }
    }

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
        return rear == front;
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
        for (int i = 0; i < arr.length; i++) {
            System.out.print("["+arr[i]+"]   ");
            System.out.println();
        }

    }


}
