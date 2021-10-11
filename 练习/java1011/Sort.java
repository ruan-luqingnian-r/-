package 练习.java1011;

import java.util.Arrays;

/**
 * @Author: ruan
 * Date: 2021/10/11 12:25
 * @Description: 各种排序算法
 */
public class Sort {
    public static void main(String[] args) {
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 1000 + 1);
        }
        System.out.println("排序前:" + Arrays.toString(arr));
        heapSort(arr);
        System.out.println("排序后:" + Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     * @param arr
     */
    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
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
    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            int minValue = arr[minIndex];
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
     * @param arr
     */
    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int index = i - 1;
            int value = arr[i];
            while (index >= 0 && value < arr[index]){
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = value;
        }
    }

    /**
     * 希尔排序
     */
    public static void shellSort(int[] arr){
        for (int gap = (arr.length / 2); gap > 0; gap /= 2){
            for (int i = gap; i < arr.length; i++) {
                int index = i - gap;
                int value = arr[i];
                while (index >= 0 && value < arr[index]){
                    arr[index + gap] = arr[index];
                    index = index - gap;
                }
                arr[index + gap] = value;
            }
        }
    }

    /**
     * 快速排序
     * @param arr
     */
    public static void quickSort(int[] arr){
        quick(arr,0, arr.length - 1);
    }

    private static void quick(int[] arr, int left, int right){
        int r = right;
        int l = left;
        int median = arr[(left + right) / 2];
        while (l < r){
            while (arr[l] < median){
                l++;
            }
            while (arr[r] > median){
                r--;
            }
            if (l >= r){
                break;
            }
            arr[l] = arr[l] ^ arr[r];
            arr[r] = arr[r] ^ arr[l];
            arr[l] = arr[l] ^ arr[r];
            if (arr[l] == median){
                r--;
            }
            if (arr[r] == median){
                l++;
            }
        }
        if (l == r){
            l++;
            r--;
        }
        if (l < right){
            quick(arr, l, right);
        }
        if (left < r){
            quick(arr, left, r);
        }
    }

    /**
     * 堆排序
     * @param arr
     */
    public static void heapSort(int[] arr){
        int temp = 0;
        for (int i = arr.length / 2 - 1; i > 0; i--) {
            adjustHeap(arr,i,arr.length);
        }
        for (int i = arr.length - 1; i > 0 ; i--) {
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,i);
        }
    }

    private static void adjustHeap(int[] arr,int i,int length){
        //取出当前元素，保存临时变量
        int temp = arr[i];
        //开始调整大顶堆
        //第一个费叶子节点 i * 2 - 1
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1){
            if ((k + 1) < length && arr[k] < arr[k + 1]){
                k++;
            }
            if (arr[k] > temp){
                arr[i] = arr[k];
                i = k;
            }else {
                break;
            }
        }
        arr[i] = temp;
    }


}
