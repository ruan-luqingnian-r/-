package DataStructures.searchalgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @PackgeName: DataStructures.searchalgorithm
 * @ClassName: BinarySearch
 * @Author: 小天才
 * Date: 2021/5/31 14:20
 * project name: 算法和数据结构
 * @Version: 0.0.1
 * @Description: 二分查找（对有序数组进行查找）
 */


 
public class BinarySearch {
    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,6,6,6,6,7,8,9};
        List<Integer> integers = binarySearch(arr, 19, 0, arr.length - 1);
        System.out.println(integers);
    }

    public static List<Integer> binarySearch(int[] arr, int value, int left, int right){

        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (left>right){
            return new ArrayList<>();
        }
        if (value > midVal){
            //向右递归
            return binarySearch(arr, value, mid + 1, right);
        }else if (value < midVal){
            //向左递归
            return binarySearch(arr, value, left, mid - 1);
        }else {
            ArrayList<Integer> indexList = new ArrayList<>();
            //向左扫描
            int temp = mid - 1;
            while (true){
                if (temp < 0 || arr[temp] != value){
                    break;
                }
                indexList.add(temp);
                temp -= 1;
            }
            indexList.add(mid);
            temp = mid + 1;
            while (true){
                if (temp > arr.length - 1 || arr[temp] != value){
                    break;
                }
                indexList.add(temp);
                temp += 1;
            }
            return indexList;
        }
    }
}
