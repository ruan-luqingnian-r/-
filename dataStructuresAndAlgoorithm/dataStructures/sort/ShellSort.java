package dataStructuresAndAlgoorithm.dataStructures.sort;

import java.util.Arrays;

/**
 * @Author: ruan
 * Date: 2021/8/18 22:43
 * @Description: 希尔排序
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {12,31,42,3,42,123,42,324,45,25,6,325,643,4,32545,65,34,21,12,3};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //移动排序
    public static void shellSort2(int[] arr){
        for(int gap = arr.length/2; gap>0;gap/=2){
            for(int i = gap;i<arr.length;i++){
                int j = i;
                int temp = arr[j];
                if(arr[j]<arr[j-gap]){
                    while(j-gap>=0 && temp<arr[j-gap]){
                        arr[j] = arr[j-gap];
                        j-=gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }

    public static void shellSort(int[] arr){
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length;i++){
                int j = i;//保存下标
                int temp = arr[j];//待插入数字
                if (arr[j] < arr[j - gap]){
                    while (j - gap >= 0 && temp > arr[j - gap]){
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }
}
