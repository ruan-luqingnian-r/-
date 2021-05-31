package DataStructures.searchalgorithm;

import java.util.Arrays;

/**
 * @PackgeName: DataStructures.searchalgorithm
 * @ClassName: InterpolationSearch
 * @Author: 小天才
 * Date: 2021/5/31 16:21
 * project name: 算法和数据结构
 * @Version: 0.0.1
 * @Description: 插值查找
 */
public class InterpolationSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        System.out.println(Arrays.toString(arr));
        int i = insertValueSearch(arr, 0, arr.length - 1, 23);
        System.out.println(i);
    }
    public static int insertValueSearch(int[] arr,int left,int right,int findVal){
        if (left > right || findVal > arr[arr.length - 1] || findVal < arr[0]){
            return -1;
        }
        //求出imd
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findVal > midVal){
            //向右查找
            return insertValueSearch(arr, mid + 1, right, findVal);
        }else if (findVal < midVal){
            //向左查找
            return insertValueSearch(arr, left, mid - 1, findVal);
        }else {
            return mid;
        }
    }
}
