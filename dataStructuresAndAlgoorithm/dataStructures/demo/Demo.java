package dataStructuresAndAlgoorithm.dataStructures.demo;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author: ruan
 * Date: 2021/8/17 10:38
 * @Description:
 */
public class Demo {
    public static void main(String[] args) {
        int[] arr = {1,2,32,2,4,2,3,5,4,55,66,7,7,8,9,34,34,34,5,4,67,6,734,5456};
        insertion(arr);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 冒泡排序
     * @param arr
     */
    public static void bubble(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]){
                    arr[j] = arr[j] ^ arr[j + 1];
                    arr[j + 1] = arr[j + 1] ^ arr[j];
                    arr[j] = arr[j] ^ arr[j + 1];
                }
            }
        }
    }

    /**
     * 选择排序
     * @param arr
     */
    public static void select(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            int minValue = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (minValue > arr[j]){
                    index = j;
                    minValue = arr[j];
                }
            }
            if (index != i){
                arr[index] = arr[i];
                arr[i] = minValue;
            }
        }
    }

    /**
     * 插入排序
     * @param arr
     */
    public static void insertion(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int index = i - 1;
            while (index >= 0 && value < arr[index]){
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = value;
        }
    }




}
