package dataStructuresAndAlgoorithm.dataStructures.link;

/**
 * @Author: ruan
 * Date: 2021/7/22 10:59
 * @Description: 环形链表于约瑟夫问题
 */
public class CircularLinkedListDemo {
    public static void main(String[] args) {
        CircularLinked circularLinked = new CircularLinked();
        circularLinked.add(20);
        circularLinked.show();
        System.out.println("=======");
        circularLinked.Joseph(2,3,20);
    }
}
/**
 * 定义节点
 */
class Baby{
    public int no;
    public Baby next;
    //构造器
    public Baby(int no) {
        this.no = no;
    }
}

/**
 * 创建环形链表
 */
class CircularLinked{
    //定义首节点
    Baby first = null;

    /**
     * 创建方法
     * @param number
     */
    public void add(int number){
        //数据校验
        if (number < 0){
            System.out.println("数据不合法");
            return;
        }
        //定义辅助节点
        Baby temp = null;
        //开始添加节点
        for (int i = 1; i <= number; i++) {
            Baby baby = new Baby(i);
            if (i == 1){
                first = baby;
                first.next = first;
                temp = first;
            }else {
                temp.next = baby;
                baby.next = first;
                temp = baby;
            }
        }
    }
    /**
     * 打印
     */
    public void show(){
        if (first == null){
            System.out.println("链表为空");
            return;
        }
        Baby temp = first;
        while (true){
            System.out.printf("小孩的编号 %d \n",temp.no);
            if (temp.next == first){
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * 约瑟夫问题
     * @param begin 起始号码
     * @param stepSize 步长
     * @param number 节点数量
     */
    public void Joseph(int begin,int stepSize,int number){
        //数据校验
        if (begin < 0 || begin > number || stepSize < 1){
            System.out.println("非法数据");
            return;
        }
        //辅助节点
        Baby temp = first;
        //指针指向最后一位
        while (true){
            if (temp.next == first){
                break;
            }
            temp = temp.next;
        }
        //将指针移动到要报数的节点
        for (int i = 0; i < begin - 1; i++) {
            //同时移动首节点和辅助指针
            first = first.next;
            temp = temp.next;
        }
        //开始报数
        while (true){
            if (temp == first){
                //只剩下一个
                break;
            }
            for (int i = 0; i < stepSize - 1; i++) {
                //同时移动
                first = first.next;
                temp = temp.next;
            }
            //first指向的就是要出圈的节点
            System.out.printf("小孩%d 出圈\n", first.no);
            //出圈
            first = first.next;
            temp.next = first;
        }
        System.out.printf("最后留在圈中的小孩编号%d \n", first.no);

    }
}
