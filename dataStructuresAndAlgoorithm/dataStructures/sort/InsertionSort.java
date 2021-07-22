package dataStructuresAndAlgoorithm.dataStructures.sort;

import java.util.Arrays;

/**
 * @Author: ruan
 * Date: 2021/7/21 20:49
 * @Description: 插入排序
 * 将无序数组看成有序无序两部分
 * 从序数组中拿出一个数在有序数组中插入
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {213,21,32,13214,2112,312312,312,32,31,312,312,22,2,2,2,2,};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr){
        int temp = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]){
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }
}
