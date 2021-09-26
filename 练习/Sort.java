package 练习;

import sun.plugin.javascript.navig.Array;

import java.util.Arrays;

/**
 * @Author: ruan
 * Date: 2021/9/26 16:59
 * @Description: 冒泡排序
 */
public class Sort {
    public static void main(String[] args) {
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 100 + 1);
        }
        System.out.println("排序前:" + Arrays.toString(arr));
        shellSort(arr);
        System.out.println("排序后:" + Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     * @param arr 待排数组
     */
    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j + 1] < arr[j]){
                    arr[j + 1] = arr[j + 1] ^ arr[j];
                    arr[j] = arr[j] ^ arr[j + 1];
                    arr[j + 1] = arr[j + 1] ^ arr[j];
                }
            }
        }
    }

    /**
     * 选择排序
     * @param arr
     */
    private static void selectSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            //保存待插入数字与下标
            int minIndex = i;
            int minValue = arr[minIndex];
            //遍历链表找到真正的最小值
            for (int j = i + 1; j < arr.length; j++) {
                if (minValue > arr[j]){
                    minIndex = j;
                    minValue = arr[j];
                }
            }
            if (minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = minValue;
            }
        }
    }

    /**
     * 插入排序
     * @param arr 待排数组
     */
    public static void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            //保存的数组
            int value = arr[i];
            //数组前一个下标
            int index = i - 1;
            while (index >= 0 && arr[index] > value){
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = value;
        }
    }

    /**
     * 希尔排序
     * @param arr 待排数组
     */
    public static void shellSort(int[] arr){
        //分组
        for (int gap = (arr.length / 2); gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                //保存数组和下标
                int j = i;
                int value = arr[j];
                if (arr[j - gap] > arr[j]){
                    while ((j - gap >= 0) && arr[j - gap] > value){
                        arr[j] = arr[j - gap];
                        j = j - gap;
                    }
                    arr[j] = value;
                }
            }
        }
    }
}
