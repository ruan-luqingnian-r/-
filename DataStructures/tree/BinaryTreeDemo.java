package DataStructures.tree;

/**
 * @PackgeName: DataStructures.tree
 * @ClassName: BinaryTreeDemo
 * @Author: 小天才
 * Date: 2021/6/3 15:14
 * project name: 算法和数据结构
 * @Version: 0.0.1
 * @Description: 二叉树
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        //创建一颗二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建需要的节点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");
        //先手动创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setLeft(node5);
        node3.setRight(node4);

        binaryTree.setRoot(root);
//        //测试
//        System.out.println("前序遍历");
//        binaryTree.preOrder();
//        //测试
//        System.out.println("中序遍历");
//        binaryTree.infixOrder();
//        //测试
//        System.out.println("后序遍历");
//        binaryTree.postOrder();
        //前序查找
        //前序遍历的次数 ： 4
//         System.out.println("前序遍历方式~~~");
//         HeroNode resNode = binaryTree.preOrderSearch(5);
//         if (resNode != null) {
//         System.out.printf("找到了， 信息为 no=%d name=%s", resNode.getNo(), resNode.getName());
//         } else {
//         System.out.printf("没有找到 no = %d 的英雄", 5);
//         }
//        System.out.println("中序遍历方式~~~");
//        HeroNode resNode = binaryTree.infixOrderSearch(5);
//        if (resNode != null) {
//            System.out.printf("找到了， 信息为 no=%d name=%s", resNode.getNo(), resNode.getName());
//        } else {
//            System.out.printf("没有找到 no = %d 的英雄", 5);
//        }
//        System.out.println("后序遍历方式~~~");
//        HeroNode resNode = binaryTree.postOrderSearch(5);
//        if (resNode != null) {
//            System.out.printf("找到了， 信息为 no=%d name=%s", resNode.getNo(), resNode.getName());
//        } else {
//            System.out.printf("没有找到 no = %d 的英雄", 5);
//        }
        System.out.println("删除前，前序遍历");
        binaryTree.preOrder();
        binaryTree.delNode(3);
        System.out.println("删除后，前序遍历");
        binaryTree.preOrder();
    }

}
//创建节点
class HeroNode{
    private int no;//序号
    private String name;//名字
    private HeroNode left;//左节点默认为空
    private HeroNode right;//右节点默认为空
    private int leftType;//如果是0则指向左子树，1则指向前驱节点
    private int rightType;
    //创建构造器
    public HeroNode(int no,String name){
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //编写前序遍历方法
    public void preOrder(){
        System.out.println(this);//输出父节点
        if (this.left != null){//向左递归
            this.left.preOrder();
        }
        if (this.right != null){//向右递归
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder(){
        if (this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null){
            this.right.infixOrder();
        }
    }

    //后续遍历
    public void postOrder(){
        if (this.left != null){
            this.left.postOrder();
        }
        if (this.right != null){
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //前序查找
    public HeroNode preOrderSearch(int no){
        System.out.println("开始前序查找");
        if (this.no == no){
            return this;
        }
        //1.则判断当前结点的左子节点是否为空， 如果不为空， 则递归前序查找
        //2.如果左递归前序查找， 找到结点， 则返回
        HeroNode resHeroNode = null;
        if (this.left != null){
            resHeroNode = this.left.preOrderSearch(no);
        }
        if (resHeroNode != null){//说明左节点找到
            return resHeroNode;
        }
        //1.左递归前序查找， 找到结点， 则返回， 否继续判断，
        //2.当前的结点的右子节点是否为空， 如果不空， 则继续向右递归前序查找
        if (this.right != null){
            resHeroNode = this.right.preOrderSearch(no);
        }

        return resHeroNode;
    }
    //中序查找
    public HeroNode infixOrderSearch(int no){

        //左递归
        HeroNode resHeroNode = null;
        if (this.left != null){
            resHeroNode = this.left.infixOrderSearch(no);
        }
        if (resHeroNode != null){
            return resHeroNode;
        }
        System.out.println("开始中序查找");
        if (this.no == no){
            return this;
        }
        if (this.right != null){
            resHeroNode = this.right.infixOrderSearch(no);
        }
        return resHeroNode;
    }
    //后序查找
    public HeroNode postOrderSearch(int no){

        HeroNode resHeroNode = null;
        if (this.left != null){
            resHeroNode = this.left.postOrderSearch(no);
        }
        if (resHeroNode != null){
            return resHeroNode;
        }
        if (this.right != null){
            resHeroNode = this.right.postOrderSearch(no);
        }
        if (resHeroNode != null){
            return resHeroNode;
        }
        System.out.println("开始后序查找");
        if (this.no == no){
            return this;
        }
        return resHeroNode;
    }
    //删除节点
    //1.如果删除的节点是叶子节点， 则删除该节点
    //2.如果删除的节点是非叶子节点， 则删除该子树
    public void delNode(int no){
        //1.判读左子节点是否是要删除的
        if (this.left != null && this.left.no == no){
            this.left = null;
            return;
        }
        //2.判断右子节点是否要删除
        if (this.right != null && this.right.no == no){
            this.right = null;
            return;
        }
        //3.向左子节点进行递归删除
        if (this.left != null){
            this.left.delNode(no);
        }
        //4.向右子节点进行递归删除
        if (this.right != null){
            this.right.delNode(no);
        }

    }
}
//创建二叉树
class BinaryTree{
    private HeroNode root;//创建根结点
    //创建前驱节点
    private HeroNode pre = null;

    public void setRoot(HeroNode root) {
        this.root = root;
    }
    //前序遍历
    public void preOrder(){
        if (this.root != null){
            this.root.preOrder();
        }else {
            System.out.println("二叉数为空");
        }
    }
    //中序遍历
    public void infixOrder(){
        if (this.root != null){
            this.root.infixOrder();
        }else {
            System.out.println("二叉树为空");
        }
    }
    //后续遍历
    public void postOrder(){
        if (this.root != null){
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空");
        }
    }
    //前序查找
    public HeroNode preOrderSearch(int no){
        if (root != null){
            return root.preOrderSearch(no);
        }else {
            return null;
        }
    }
    //中序查找
    public HeroNode infixOrderSearch(int no){
        if (root != null){
            return root.infixOrderSearch(no);
        }else {
            return null;
        }
    }
    //后续查找
    public HeroNode postOrderSearch(int no){
        if (root != null){
            return root.postOrderSearch(no);
        }else {
            return null;
        }
    }
    //删除节点
    public void delNode(int no){
        if (root != null){
            //如果只有一个root
            if (root.getNo() == no){
                root = null;
            }else {
                //递归删除
                root.delNode(no);
            }
        }else {
            System.out.println("空树无法删除");
        }
    }
    //对二叉树线索化的方法
    public void threadedNodes(HeroNode node){
        if (node == null){
            return;
        }
        //1.先处理左子树
        threadedNodes(node.getLeft());
        if (node.getLeft() == null){
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if (pre != null && pre.getRight() == null){
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;//每处理一个节点后让当前节点是下一个的后续节点

        threadedNodes(node.getRight());

    }
    //遍历线索化二叉树的方法
    public void list(){
        //创建辅助节点
        HeroNode node = root;
        while (node != null){
            while (node.getLeftType() == 0){
                node = node.getLeft();
            }
            //打印当前节点
            System.out.println(node);
            while (node.getRightType() == 1){
                node = node.getRight();
                System.out.println(node);
            }
            //替换节点
            node = node.getRight();
        }

    }


}
