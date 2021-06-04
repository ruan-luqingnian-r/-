package DataStructures.tree;

/**
 * @PackgeName: DataStructures.tree
 * @ClassName: ArrBinaryTreeDemo
 * @Author: 小天才
 * Date: 2021/6/4 11:51
 * project name: 算法和数据结构
 * @Version: 0.0.1
 * @Description:
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder();
    }
}
//编写一个ArrBinaryTree,实现顺序存储二叉树
class ArrBinaryTree{
    private int[] arr;//存储数据节点的数组
    public ArrBinaryTree(int[] arr){
        this.arr = arr;
    }
    /**
     * //编写一个方法，完成顺序存储二叉树的前序遍历
     * @param index 数组的下标
     */
    public void preOrder(int index){
        //如果数组为空
        if (arr.length == 0 || arr == null){
            System.out.println("数组为空，不能二叉树前序遍历");
            return;
        }
        //输出当前元素
        System.out.println(arr[index]);
        //向左递归
        if ((2 * index + 1) < arr.length){
            preOrder(2 * index + 1);
        }
        //向右递归
        if ((2 * index + 2) < arr.length){
            preOrder(2 * index + 2);
        }

    }
    //重载preOrder()
    public void preOrder(){
        preOrder(0);
    }
}