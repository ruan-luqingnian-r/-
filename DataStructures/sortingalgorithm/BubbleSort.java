package DataStructures.sortingalgorithm;

/**
 * @PackgeName: DataStructures.sortingalgorithm
 * @ClassName: bubbleSort
 * @Author: 小天才
 * Date: 2021/5/29 9:56
 * project name: 算法和数据结构
 * @Version: 0.0.1
 * @Description: 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arrry = {3,9,-1,10,-2};
        System.out.println("排序前");
        for (int i : arrry) {
            System.out.print(i+" ");
        }
        int[] sort = sort(arrry);
        System.out.println();
        System.out.println("排序后");
        for (int i : sort) {
            System.out.print(i+" ");
        }


    }
    public static int[] sort(int[] array){
        int temp;//作为交换的辅助遍历
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < (array.length - 1 - i); j++) {
                if (array[j] > array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }
}
