package dataStructuresAndAlgoorithm.dataStructures.sort;

import java.util.Arrays;

/**
 * @Author: ruan
 * Date: 2021/8/19 21:40
 * @Description: 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {12,31,42,3,42,123,42,324,45,25,6,325,643,4,32545,65,34,21,12,3};
        sort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int value = arr[(left + right) / 2];
        int temp = 0;
        while (l < r){
            while (arr[l] < value){
                l++;
            }
            while (arr[r] > value){
                r--;
            }
            if (l >= r){
                break;
            }
            //开始交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == value){
                r--;
            }
            if (arr[r] == value){
                l++;
            }
        }
        if (l == r){
            l++;
            r--;
        }
        //向左递归
        if (left < r){
            sort(arr, left, r);
        }
        //向右递归
        if (l < right){
            sort(arr, l, right);
        }


    }


}
