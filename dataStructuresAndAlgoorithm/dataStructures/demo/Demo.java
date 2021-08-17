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
        bubble(arr);
        System.out.println(Arrays.toString(arr));

    }

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




}
