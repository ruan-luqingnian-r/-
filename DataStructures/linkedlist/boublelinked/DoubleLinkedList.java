package DataStructures.linkedlist.boublelinked;

class DoubleLinkedListDemo {

    public static void main(String[] args) {
        //测试
        //先创建几个英雄
        HeroNode heroNode1 = new HeroNode(1,"卡蜜尔","青钢影");
        HeroNode heroNode2 = new HeroNode(2,"艾翁","翠神");
        HeroNode heroNode3 = new HeroNode(3,"克烈","暴怒骑士");
        HeroNode heroNode4 = new HeroNode(4,"塔莉垭","岩雀");

        //创建链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.ulAdd(heroNode1);
        doubleLinkedList.ulAdd(heroNode3);
        doubleLinkedList.ulAdd(heroNode2);
        doubleLinkedList.ulAdd(heroNode4);
        doubleLinkedList.list();
        HeroNode heroNode = new HeroNode(4,"(new)塔莉垭","(new)岩雀");
        doubleLinkedList.upDate(heroNode);
        System.out.println("===更新后的链表===");
        doubleLinkedList.list();
        doubleLinkedList.deleteNode(3);
        System.out.println("===删除后的链表===");
        doubleLinkedList.list();


    }
}
//首先定义一个节点(双向链表)
class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;
    public HeroNode pre;
    //创建构造器
    public HeroNode(int no,String name,String nickName){
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }
    //重写toString方法

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
//创建一个双向链表
class DoubleLinkedList{
    //定义头节点
    private HeroNode head = new HeroNode(0,"","");

    /**
     * 遍历链表的方法
     */
    public void list(){
        //判断链表是否为空
        if(head.next == null){
            System.out.println("此链表为空");
            return;
        }
        //添加辅助节点
        HeroNode temp = head.next;
        while (temp != null){
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }
    /**
     * 向链表尾部添加节点(无需添加)
     */
    public void ulAdd(HeroNode heroNode){
        //添加辅助节点
        HeroNode temp = head;
        //遍历节点，找到尾部
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.pre = temp;
    }
    /**
     * 更新节点
     */
    public void upDate(HeroNode heroNode){
        //判断链表是否为空
        if (head.next == null){
            System.out.println("此链表为空");
            return;
        }
        //添加辅助节点
        HeroNode temp = head;
        //定义是否找到此节点
        boolean flag = false;
        while (true){
            if (temp == null){
                //已经到表表尾
                break;
            }
            if (temp.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.nickName = heroNode.nickName;
            temp.name = heroNode.name;
        }
    }
    /**
     * 删除节点
     */
    public void deleteNode(int no){
        //判断链表是否为空
        if (head.next == null){
            System.out.println("此链表为空");
            return;
        }
        //定义辅助节点和寻找要删除的节点
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if (temp == null){
                //已到表尾
                break;
            }
            if (temp.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.pre.next = temp.next;
            if (temp.next != null){
                temp.next.pre = temp.pre;
            }else {
                System.out.println("节点不存在");
            }
        }
    }
}
