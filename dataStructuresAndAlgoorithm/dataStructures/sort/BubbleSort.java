package dataStructuresAndAlgoorithm.dataStructures.sort;

import java.util.Arrays;

/**
 * @Author: ruan
 * Date: 2021/7/21 20:02
 * @Description: 冒泡排序
 * 从第一个开始，和之后的逐一进行比较，进行换位
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {213,21,32,13214,2112,312312,312,32,31,312,312,22,2,2,2,2,};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr){

        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
