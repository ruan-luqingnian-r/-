package DataStructures.linkedlist;

public class Josepfu {
    public static void main(String[] args) {
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        circularLinkedList.add(20);
        circularLinkedList.show();
        circularLinkedList.countBoy(2,3,20);
    }
}
class Boy{
    private int no;
    private Boy next;

    public Boy(int no){
        this.no = no;
    }











    

    public void setNo(int no) {
        this.no = no;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    public int getNo() {
        return no;
    }

    public Boy getNext() {
        return next;
    }
}
class CircularLinkedList{
    //定义首节点
    private Boy first = null;
    /**
     * 定义添加方法
     */
    public void add(int num){
        //先做数据校验
        if (num < 0){
            System.out.println("数据有误");
            return;
        }
        //定义辅助节点、
        Boy temp = null;
        for (int i = 1; i <= num ; i++) {

            //根据传入数据创建节点
            Boy boy = new Boy(i);
            //如果是第一个小孩
            if (i == 1){
                first = boy;
                first.setNext(first);
                temp = first;
            }else {
                temp.setNext(boy);
                boy.setNext(first);
                temp = boy;//后移
            }
        }
    }
    /**
     * 输出
     */
    public void show(){
        //判断链表是否为空
        if(first == null){
            System.out.println("链表为空");
            return;
        }
        //添加辅助指针定义
        Boy temp = first;
        while (true){
            System.out.printf("小孩的编号 %d \n", temp.getNo());
            if (temp.getNext() == first){
                //已经遍历完毕
                break;
            }
            //后移辅助节点
            temp = temp.getNext();
        }
    }

    /**
     * 约瑟夫问题
     * @param startNo 开始编号
     * @param countNumber 每次叫号
     * @param nums 共有人数
     */
    public void countBoy(int startNo,int countNumber,int nums){
        //数据交易
        if (first == null || startNo > nums || startNo < 1){
            System.out.println("数据有误");
            return;
        }
        //定义辅助指针
        Boy temp = first;
        //将此指针放在最后一位
        while (true){
            if (temp.getNext() == first){
                break;
            }
            temp = temp.getNext();
        }
        //报数前要将指针移动要开始报数的节点
        for (int i = 0; i < startNo - 1 ; i++) {
            first = first.getNext();
            temp = temp.getNext();
        }
        //开始循环报数
        while (true){
            if (temp == first){
                //说明只剩下一个
                break;
            }
            //同时移动
            for (int i = 0; i <countNumber -1 ; i++) {
                first = first.getNext();
                temp = temp.getNext();
            }
            //现在First指向的就是要出去的小孩
            System.out.printf("小孩%d 出圈\n", first.getNo());
            //将他出圈
            first = first.getNext();
            temp.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩编号%d \n", first.getNo());

    }
}




