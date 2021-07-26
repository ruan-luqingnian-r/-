package dataStructuresAndAlgoorithm.dataStructures.link;

/**
 * @Author: ruan
 * Date: 2021/7/21 19:29
 * @Description: 双向链表
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        //测试
        //创建节点
        DoubleNode node1 = new DoubleNode(1, "赵");
        DoubleNode node2 = new DoubleNode(2, "钱");
        DoubleNode node3 = new DoubleNode(3, "孙");
        DoubleNode node4 = new DoubleNode(4, "李");
        //创建链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        /*doubleLinkedList.ulAdd(node1);
        doubleLinkedList.ulAdd(node2);
        doubleLinkedList.ulAdd(node3);
        doubleLinkedList.ulAdd(node4);
        System.out.println("=========");
        doubleLinkedList.list();
        doubleLinkedList.delete(3);
        System.out.println("=========");
        doubleLinkedList.list();
        doubleLinkedList.upDate(4,"哈哈");
        System.out.println("=========");
        doubleLinkedList.list();*/
        doubleLinkedList.olAdd(node2);
        doubleLinkedList.olAdd(node1);
        doubleLinkedList.olAdd(node4);
        doubleLinkedList.olAdd(node3);
        doubleLinkedList.list();
    }
}
/**
 * 定义节点
 */
class DoubleNode{
    public int id;//节点序号
    public String name;//节点名字
    public DoubleNode nextNode;//指向下一个节点
    public DoubleNode preNode;//指向上一个节点
    /**
     * 创建构造器
     */
    public DoubleNode(int id, String name) {
        this.id = id;
        this.name = name;
    }
    /**
     * 重写toString方法
     */
    @Override
    public String toString() {
        return "DoubleNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
/**
 * 定义链表
 */
class DoubleLinkedList{
    //创建空数据的头节点
    DoubleNode head = new DoubleNode(0,"");
    /**
     * 新增方法(无序)
     */
    public void ulAdd(DoubleNode newNode){
        //创建辅助节点
        DoubleNode temp = head;
        //遍历链表
        while (true){
            if (temp.nextNode == null){
                //找到链表尾部
                break;
            }
            //节点后移
            temp = temp.nextNode;
        }
        //将尾部链接新节点
        temp.nextNode = newNode;
        //新节点的上一个指向尾部
        newNode.preNode = temp;
    }
    /**
     * 删除链表
     */
    public void delete(int no){
        DoubleNode temp =  head.nextNode;
        boolean flag = false;
        //遍历链表找到该节点
        while (true){
            if (temp == null){
                break;
            }
            if (temp.id == no){
                flag = true;
                break;
            }
            temp = temp.nextNode;
        }
        if (flag){
            //找到待删除节点
            temp.preNode.nextNode = temp.nextNode;
            temp.nextNode.preNode = temp.preNode;
        }else {
            System.out.println("无此节点");
        }
    }
    /**
     * 修改节点
     */
    public void upDate(int no,String name){
        DoubleNode temp = head.nextNode;
        boolean flag = false;
        while (true){
            if (temp == null){
                break;
            }
            if (temp.id == no){
                flag = true;
                break;
            }
            temp = temp.nextNode;
        }
        if (flag){
            temp.name = name;
        }else {
            System.out.println("无此节点");
        }
    }
    /**
     * 打印链表
     */
    public void list(){
        DoubleNode temp = head;
        while (true){
            if (temp.nextNode == null){
                break;
            }
            temp = temp.nextNode;
            System.out.println(temp.toString());
        }
    }
    /**
     * 添加链表(有序添加)
     */
    public void olAdd(DoubleNode newNode){
        DoubleNode temp = head;
        boolean flag = false;
        boolean flag1 = false;
        while (true){
            if (temp.nextNode == null){
                //在尾部插入
                flag1 = true;
                break;
            }
            if (temp.nextNode.id > newNode.id ){
                flag = true;
                break;
            }
            if (temp.nextNode.id == newNode.id){

                break;
            }
            temp = temp.nextNode;
        }
        if (flag1){
            temp.nextNode = newNode;
            newNode.preNode = temp;
        }else if (flag){
            newNode.nextNode = temp.nextNode;
            temp.nextNode.preNode = newNode;
            temp.nextNode = newNode;
            newNode.preNode = temp;
        }else {
            System.out.println("节点存在");
        }
    }
}
