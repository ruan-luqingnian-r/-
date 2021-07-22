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
        int[] arr = {213,21,32,13214,2112,312312,312,32,31,312,312,22,2,2,2,2,};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr){
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minPos] > arr[j]){
                    minPos = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[minPos];
            arr[minPos] = temp;

        }

    }
}
