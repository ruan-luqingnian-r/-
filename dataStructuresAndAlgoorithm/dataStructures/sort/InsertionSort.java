package dataStructuresAndAlgoorithm.dataStructures.sort;

import java.util.Arrays;

/**
 * @Author: ruan
 * Date: 2021/7/21 20:49
 * @Description: 插入排序
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {12,31,42,3,42,123,42,324,45,25,6,325,643,4,32545,65,34,21,12,3};
        int[] sort = sort(arr);
        System.out.println(Arrays.toString(sort));
    }

    /**
     * 插入排序
     * @param arr 待排数组
     * @return 排序后的数组
     */
    public static int[] sort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            //待插入是数据
            int value = arr[i];
            //待排数字前一个的下标
            int index = i - 1;
            while (index >= 0 && value < arr[index]){
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = value;
        }
        return arr;
    }

}
