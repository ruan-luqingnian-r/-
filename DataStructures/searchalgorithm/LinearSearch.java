package DataStructures.searchalgorithm;

/**
 * @PackgeName: DataStructures.searchalgorithm
 * @ClassName: LinearSearch
 * @Author: 小天才
 * Date: 2021/5/31 14:11
 * project name: 算法和数据结构
 * @Version: 0.0.1
 * @Description: 线性查找
 */
public class LinearSearch {

    public static void main(String[] args) {
        int arr[] = {1,9,11,-1,34,89};
        int index = seqSearch(arr, 11);
        if (index == -1){
            System.out.println("未找到");
        }else{
            System.out.println("找到，下标为="+index);
        }
    }
    public static int seqSearch(int[] arr,int value){
        //线性查找，逐一比对发现有相同的值时返回下标
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value){
                return i;
            }
        }
        return -1;
    }

}
