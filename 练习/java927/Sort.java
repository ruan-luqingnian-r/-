package 练习.java927;


import java.util.Arrays;

/**
 * @Author: ruan
 * Date: 2021/9/27 16:19
 * @Description: 排序算法
 */
public class Sort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 1000 + 1);
        }
        System.out.println("排序前:" + Arrays.toString(arr));
        insertionSort(arr);
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
            //保存下标和数值
            int minIndex = i;
            int minValue = arr[minIndex];
            //遍历数组找到真正的最小值
            for (int j = i + 1; j < arr.length; j++) {
                if (minValue > arr[j]){
                    minIndex = j;
                    minValue = arr[j];
                }
            }
            if (i != minIndex){
                arr[minIndex] = arr[i];
                arr[i] = minValue;
            }
        }
    }

    /**
     * 插入排序
     * @param arr
     */
    public static void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            //保存下标和前一个数组值
            int value = arr[i];
            int index = i - 1;
            //遍历数组找到数据位置
            while (index >= 0 && arr[index] > value){
                arr[index + 1] = arr[index];
                index--;
            }
            //找到待插入位置
            arr[index + 1] = value;
        }

    }

    /**
     * 希尔排序
     * @param arr
     */
    public static void shellSort(int[] arr){
        //分组
        for (int gap = (arr.length / 2); gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                //保存下标和数组
                int j = gap;
                int value = arr[j];
                if (arr[gap - j] > arr[j]){
                    while ((gap - j) >= 0 && arr[gap - j] > arr[j]){
                        arr[j] = arr[gap - j];
                        gap = gap - j;
                    }
                    arr[j] = value;
                }

            }
        }
    }



}
