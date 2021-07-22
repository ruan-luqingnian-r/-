package dataStructuresAndAlgoorithm.dataStructures.link;

/**
 * @Author: ruan
 * Date: 2021/7/21 19:29
 * @Description: 双向链表
 */
public class DoubleLinkedListDemo {
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
