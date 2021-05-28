package DataStructures.linkedlist.singlylinked;


import java.util.Stack;

/**
 * 单链表
 */
public class SinglyLinkedListDemo {

    public static void main(String[] args) {
        //测试
        //先创建几个英雄
        HeroNode heroNode1 = new HeroNode(1,"卡蜜尔","青钢影");
        HeroNode heroNode2 = new HeroNode(2,"艾翁","翠神");
        HeroNode heroNode3 = new HeroNode(3,"克烈","暴怒骑士");
        HeroNode heroNode4 = new HeroNode(4,"塔莉垭","岩雀");
//        //创建链表(无序添加)
//        System.out.println("===创建链表(无序添加)===");
//        SinglyLinkedList singlyLinkedList1 = new SinglyLinkedList();
//        singlyLinkedList1.ulAdd(heroNode4);
//        singlyLinkedList1.ulAdd(heroNode1);
//        singlyLinkedList1.ulAdd(heroNode2);
//        singlyLinkedList1.ulAdd(heroNode3);
//        //来吧，展示
//        singlyLinkedList1.list();
        //创建链表(无序添加)
        System.out.println("===创建链表(有序添加)===");
        SinglyLinkedList singlyLinkedList2 = new SinglyLinkedList();
        singlyLinkedList2.olAdd(heroNode4);
        singlyLinkedList2.olAdd(heroNode1);
        singlyLinkedList2.olAdd(heroNode2);
        singlyLinkedList2.olAdd(heroNode3);
        singlyLinkedList2.olAdd(heroNode3);
        System.out.println("源列表的情况==");
        singlyLinkedList2.list();
        reNode(singlyLinkedList2.getHeadNode());
        System.out.println("反转后的情况==");
        singlyLinkedList2.list();
//        //来吧，展示
//        singlyLinkedList2.list();
//        singlyLinkedList2.upDate(new HeroNode(4,"(new)塔莉垭","(new)岩雀"));
//        System.out.println("===更新后的链表===");
//        singlyLinkedList2.list();
//        singlyLinkedList2.delete(4);
//        System.out.println("===删除后的链表===");
//        singlyLinkedList2.list();
//        getLength(singlyLinkedList2.getHeadNode());
//        System.out.println(getLength(singlyLinkedList2.getHeadNode()));
        System.out.println("反转打印");
        rePrintln(singlyLinkedList2.getHeadNode());

    }

    //逆序打印
    public static void rePrintln(HeroNode head){
        Stack<HeroNode> stack = new Stack<>();
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        //创建辅助节点
        HeroNode temp = head.next;

        while (temp != null){
            stack.push(temp);
            temp = temp.next;
        }
        while (stack.size() > 0){
            System.out.println(stack.pop());
        }

    }
    //获取单链表的节点个数
    public static int getLength(HeroNode headNode){
        if (headNode.next == null){
            System.out.println("此链表为空");
            return 0;
        }
        //定义辅助变量
        int length = 0;
        HeroNode temp = headNode.next;
        while (temp != null){
            length++;
            temp = temp.next;
        }
        return length;
    }
    //查找单链表的倒数第k个节点
    public static HeroNode findLastNode(HeroNode head,int index){

        if (head.next == null){
            System.out.println("链表为空");
            return null;
        }
        int size = getLength(head);

        if (index <= 0 || index > size){
            return null;
        }
        HeroNode temp = head.next;
        for (int i = 0; i < size - index ; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public static void reNode(HeroNode head){
        if (head.next == null){
            return;
        }
        //定义一个辅助节点
        HeroNode temp = head.next;
        //定义当前节点的下一个节点
        HeroNode next = null;
        //定义一个新的链表头
        HeroNode reHead = new HeroNode(0,"","");
        //遍历初始的链表
        while (temp != null){
            next = temp.next;
            temp.next = reHead.next;
            reHead.next = temp;
            temp = next;
        }
        head.next = reHead.next;
    }

}

//定义节点
class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;//指向下一个节点

    //构造方法
    public HeroNode(int no,String name,String nickName){
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    //重写toString方法，方便展示
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}

//定义链表
class SinglyLinkedList{
    //先初始化一个头节点,此头节点不保存数据
    private HeroNode headNode = new HeroNode(0,"","");

    public HeroNode getHeadNode() {
        return headNode;
    }

    //向链表内添加节点
    //1.遍历节点找到链表尾部 next = null；
    //2.将这个节点的地址域next指向要添加的节点
    public void ulAdd(HeroNode heroNode){
        //需要定义一个辅助节点，因为头节点用于定位链表，不能动。
        HeroNode temp = headNode;
        //遍历节点找到链表的尾部
        while (true){
            if (temp.next == null){
                break;
            }
            //后移一个节点
            temp = temp.next;
        }
        //将要新增的节点添加到上一个节点的尾部
        temp.next = heroNode ;
    }
    //打印链表
    public void list(){
        //判断链表是否为空
        if (headNode.next == null){
            System.out.println("链表为空，等待添加");
            return;
        }
        //同理，链表的head不能动，需要添加一个新的辅助节点
        HeroNode temp = headNode.next;
        //遍历链表
        while (true){
            //找到表尾
            if (temp == null){
                break;
            }
            //输出节点信息
            System.out.println(temp.toString());
            //后移链表
            temp = temp.next;
        }
    }
    public void olAdd(HeroNode heroNode){
        //还是由于变量头不能动，所以要加入辅助节点
        HeroNode temp = headNode;
        boolean flag = false;//用来定义插入的编号是否存在
        //遍历链表
        while (true){
            if (temp.next == null){
                //说明temp节点已经在链表尾部
                break;
            }
            if (temp.next.no > heroNode.no){
                //说明找到了要插入的位置，就在temp后面
                break;
            }else if (temp.next.no == heroNode.no){
                //说明编号已经存在
                flag = true;
                break;
            }
            //节点后移
            temp = temp.next;
        }
        //开始插入
        if (flag){
            System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入\n", heroNode.no);
        }else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }
    //更新节点，（no不必变，如果no改变则是添加）
    public void upDate(HeroNode newHeroNode){
        //同样，需要辅助节点
        if (headNode.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = headNode;
        boolean flag = false;
        while (true){
            if (temp == null){
                //已经到头
                break;
            }
            //判断是否存在该节点
            if (temp.no == newHeroNode.no){
                flag = true;
                break;
            }
            //后移节点
            temp = temp.next;
        }

        if (flag){
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        }else {
            System.out.println("此链表中不存在此节点");
        }
    }
    //删除节点
    public void delete(int no){
        if (headNode.next == null){
            System.out.println("链表内容为空");
            return;
        }
        HeroNode temp = headNode;
        boolean flag = false;//是否找到此节点
        while (true){
            if (temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.next = temp.next.next;
        }else {
            System.out.println("此链表中不存在此节点");
        }
    }


}

