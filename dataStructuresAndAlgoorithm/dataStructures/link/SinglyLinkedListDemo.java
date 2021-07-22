package dataStructuresAndAlgoorithm.dataStructures.link;

/**
 * @Author: ruan
 * Date: 2021/7/21 15:51
 * @Description: 单向链表
 */
public class SinglyLinkedListDemo{
    public static void main(String[] args) {
        //测试
        //先创建几个节点
        MyNode node1 = new MyNode(1,"赵");
        MyNode node2 = new MyNode(2,"钱");
        MyNode node3 = new MyNode(3,"孙");
        MyNode node4 = new MyNode(4,"李");
        //创建链表
        System.out.println("====无序链表====");
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.olAdd(node2);
        singlyLinkedList.olAdd(node1);
        singlyLinkedList.olAdd(node4);
        singlyLinkedList.olAdd(node3);
        System.out.println("==============");
        singlyLinkedList.list();
        singlyLinkedList.deleteNode(3);
        System.out.println("==============");
        singlyLinkedList.list();
        singlyLinkedList.upDate(4,"哈哈");
        System.out.println("==============");
        singlyLinkedList.list();
    }
}

/**
 * 定义节点
 */
class MyNode{
    public int id;//节点序号
    public String name;//节点名字
    public MyNode nextNode;//指向下一个节点

    //创建构造器
    public MyNode(int id, String name) {
        this.id = id;
        this.name = name;

    }

    @Override
    public String toString() {
        return "myNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nextNode=" + nextNode +
                '}';
    }
}
/**
 * 创建链表
 */
class SinglyLinkedList{
    //定义空头节点不保存数据
    MyNode headNode = new MyNode(0,"");
    /**
     * 向链表内添加节点（无序添加）
     * @param node
     */
    public void ulAdd(MyNode node){
        //因为头节点不能动所以首先要创建辅助节点用于遍历整个链表
        MyNode temp = headNode;
        //遍历链表找到待加入位置
        //遍历链表
        while (true){
            //判断是否到尾部
            if (temp. nextNode == null){
                //已经到遍历到链表尾部
                break;
            }
            //辅助节点后移,一个个节点遍历
            temp =  temp.nextNode;
        }
        //将队列尾部的下一个指向待插入节点
        temp.nextNode = node;
    }

    /**
     * 向链表内添加节点(有序添加)
     */
    public void olAdd(MyNode node){
        //定义辅助节点
        MyNode temp = headNode;
        boolean flag = false;//是否找到带插入位置
        //遍历节点
        while (true){
            if (temp.nextNode == null){
                //到队尾
                break;
            }
            if (temp.nextNode.id > node.id){
                //已经找到位置
                break;
            }else if (temp.nextNode.id == node.id){
                //已经存在该节点
                flag = true;
                break;
            }
            //节点后移
            temp = temp.nextNode;
        }
        if (flag){
            System.out.println("已经存在");
        }else {
            node.nextNode = temp.nextNode;
            temp.nextNode = node;
        }
    }

    /**
     * 打印链表
     */
    public void list(){
        //首先判断链表是否为空
        if (headNode.nextNode == null){
            System.out.println("链表为空");
            return;
        }
        //同样，头节点不能动，定义辅助节点帮助遍历整个链表
        MyNode temp = headNode.nextNode;
        //遍历整个链表
        while (true){
            //遍历到链表尾部
            if (temp == null){
                //找到尾部
                break;
            }
            //输出节点信息
            System.out.println(temp.toString());
            //节点后移
            temp = temp.nextNode;
        }
    }

    /**
     * 更新节点
     * @param no
     */
    public void upDate(int no,String name){
        //判断是否为空
        if (headNode.nextNode == null){
            System.out.println("链表为空");
            return;
        }
        //定义辅助链表
        MyNode temp = headNode.nextNode;
        boolean flag = false;//是否找到待插入的节点
        //遍历节点
        while (true){
            if (temp == null){
                //已经到尾部
                break;
            }
            //是否存在该节点
            if (temp.id == no){
                flag = true;
                break;
            }
            //节点后移
            temp = temp.nextNode;
        }
        if (flag){
            //找到此节点
            temp.name = name;
        }else {
            System.out.println("此链表中没有此节点");
        }
    }

    /**
     * 删除节点
     * @param no
     */
    public void deleteNode(int no){
        //判断链表是否为空
        if (headNode.nextNode == null){
            System.out.println("链表为空");
            return;
        }
        //定义辅助节点
        MyNode temp = headNode;
        boolean flag = false;//是否找到此节点
        //遍历链表,找到待删除节点的上一个节点
        while (true){
            if (temp.nextNode == null){
                //到了尾部
                break;
            }
            if (temp.nextNode.id == no){
                flag = true;
                break;
            }
            //节点后移
            temp = temp.nextNode;
        }
        if (flag){
            //找到此节点
            temp.nextNode = temp.nextNode.nextNode;
        }else {
            System.out.println("无此节点");
        }
    }
}
