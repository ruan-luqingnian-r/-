package DataStructures.tree;

/**
 * @PackgeName: DataStructures.tree
 * @ClassName: ThreadedBinaryTreeDemo
 * @Author: 小天才
 * Date: 2021/6/5 9:44
 * project name: 算法和数据结构
 * @Version: 0.0.1
 * @Description:
 */
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        //创建一颗二叉树
        BinaryTree binaryTree = new BinaryTree();
        //测试中序线索话二叉树
        //创建需要的节点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(3, "吴用");
        HeroNode node3 = new HeroNode(6, "卢俊义");
        HeroNode node4 = new HeroNode(8, "林冲");
        HeroNode node5 = new HeroNode(10, "关胜");
        HeroNode node6 = new HeroNode(14, "tom");
        //先手动创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        binaryTree.setRoot(root);
        binaryTree.threadedNodes(root);
        //测试以10为测试
        HeroNode leftNode = node5.getLeft();
        System.out.println(leftNode.toString());
        //当线索化二叉树后无法使用之前的遍历方法
        System.out.println("使用线索化方式遍历二叉树");
        binaryTree.list();
    }
}

