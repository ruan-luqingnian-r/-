package DataStructures.queue;

import java.util.Scanner;

/**
 * 数组模拟队列
 */
public class ArrayQueue {
    public static void main(String[] args) {
        boolean loop = true;
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
                case 's' : queue.showQueue();
                break;
                case 'e' :
                    System.out.println("==退出程序==");
                    loop = false;
                break;
                case 'a' :
                    System.out.print("请输入:");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g' : int i = queue.getQueue();
                    System.out.println("===取出的数据是===");
                    System.out.println(i);
                    break;
                case 'h' : int j = queue.headQueue();
                    System.out.println("===对头的数据是===");
                    System.out.println(j);
                    break;
            }
        }

    }
}
//使用数组模拟队列
class Queue {
    private int maxSize;//声明队列容量
    private int front;//队头
    private int rear;//队尾
    private int[] arr;//用数组模拟队列

    //创建队列构造器
    public Queue(int size){
        maxSize = size;
        arr = new int[maxSize];
        front = -1;//指向队列头
        rear = -1;//指向队列尾
    }

    //判断队列是否满
    public boolean isFull(){
        return rear == maxSize - 1;
    }
    //判断队列是否为空
    public boolean isNull(){
        return rear == front;
    }
    //添加数据
    public void addQueue(int n){
        if (isFull()){
            System.out.println("队列已满，无法添加");
            return;
        }else {
            rear++;
            arr[rear] = n;
        }
    }
    //获取数据（出队列）
    public int getQueue(){
        if (isNull()){
            System.out.println("队列为空");
        }
        front++;
        return arr[front];
    }
    //显示队列所有数据
    public void showQueue(){
        if (isNull()){
            System.out.println("队列为空");
        }else {
            for (int i = 0; i < arr.length; i++) {
                System.out.printf("arr[%d]=%d\n",i,arr[i]);
            }
        }

    }
    //显示对头信息(不取数据)
    public int headQueue(){
        if (isNull()){
            System.out.println("队列为空，无数据");
        }
        return arr[front+1];
    }
}
