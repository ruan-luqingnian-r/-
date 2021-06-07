package DataStructures.huffmantree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @PackgeName: DataStructures.huffmantree
 * @ClassName: HeffmanTree
 * @Author: 小天才
 * Date: 2021/6/7 14:39
 * project name: 算法和数据结构
 * @Version: 0.0.1
 * @Description: 霍夫曼树
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13,7,8,3,29,6,1};
        Node node = creatHuffmanTree(arr);
        preOrder(node);

    }
    /**
     * 创建赫夫曼树的方法
     */
    public static Node creatHuffmanTree(int[] arr){
        //第一步为了操作方法遍历数组写入node
        List<Node> nodeList = new ArrayList<>();
        for (int value : arr) {
            nodeList.add(new Node(value));
        }

        while (nodeList.size() > 1){
            //先排序 从小到大
            Collections.sort(nodeList);
            System.out.println("处理之前node"+nodeList.toString());
            //取出权值最少的两个节点
            Node left = nodeList.get(0);
            Node right = nodeList.get(1);
            //构建新的二叉树
            Node parent = new Node(left.value + right.value);
            parent.left = left;
            parent.right = right;
            //处理过二叉树
            nodeList.remove(left);
            nodeList.remove(right);
            //将parent加入到node
            nodeList.add(parent);
            System.out.println("第一次处理值后"+nodeList.toString());
        }
        System.out.println("返回的霍夫曼树");
        return nodeList.get(0);
    }
    /**
     * 前序遍历
     */
    public static void preOrder(Node root){
        if (root != null){
            root.preOrder();
        }else {
            System.out.println("空树");
        }
    }
}
/**
 * 创建节点
 * 为了让Node 对象实现排序Collections
 */
class Node implements Comparable<Node>{
    int value;//节点权重
    Node left;//左子节点
    Node right;//右子节点
    //创建构造器
    public Node(int value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        //表示从小到大
        return this.value - o.value;
    }
    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if (this.left != null){
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }
    }
}
