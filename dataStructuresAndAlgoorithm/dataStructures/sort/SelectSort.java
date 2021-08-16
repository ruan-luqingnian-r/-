package dataStructuresAndAlgoorithm.dataStructures.sort;

import java.util.Arrays;

/**
 * @Author: ruan
 * Date: 2021/7/21 20:19
 * @Description: 选择排序
 * 默认第一个值为最小值，逐一进行比较，找到真正的最小值，进行交换
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {12,31,42,3,42,123,42,324,45,25,6,325,643,4,32545,65,34,21,12,3};
        int[] sort = sort(arr);
        System.out.println(Arrays.toString(sort));
    }
    public static int[] sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            int minValue = arr[min];
            for (int j = i + 1; j < arr.length; j++) {
                //找到最小的值
                if (minValue > arr[j]){
                    min = j;
                    minValue  = arr[j];
                }
            }
            if (min != i){
                arr[min] = arr[i];
                arr[i] = minValue;
            }
        }
        return arr;
    }
}
