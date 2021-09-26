package 练习;

import sun.plugin.javascript.navig.Array;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @Author: ruan
 * Date: 2021/9/26 16:59
 * @Description: 冒泡排序
 */
public class Sort {
    public static void main(String[] args) {
        int[] arr = new int[80000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 100 + 1);
        }
        //System.out.println("排序前:" + Arrays.toString(arr));
        //shellSort(arr);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println("开始排序:"+simpleDateFormat.format(new Date()));
        quickSort(arr,0, arr.length - 1);
        //shellSort(arr);
        System.out.println("开始完成:"+simpleDateFormat.format(new Date()));
        //System.out.println("排序后:" + Arrays.toString(arr));
        ArrayList<Integer> list = binarySearch(arr, 66, 0, arr.length);
        System.out.println(list.size());
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

    /**
     * 快速排序
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr,int left,int right){
        //保存相关遍历
        int l = left;
        int r = right;
        int middle = arr[(left + right) / 2];
        while (l < r){
            while (arr[l] < middle){
                l++;
            }
            while (arr[r] > middle){
                r--;
            }
            if (l >= r){
                break;
            }
            //开始交换
            arr[l] = arr[l] ^ arr[r];
            arr[r] = arr[r] ^ arr[l];
            arr[l] = arr[l] ^ arr[r];
            if (arr[l] == middle){
                r--;
            }
            if (arr[r] == middle){
                l++;
            }
        }
        if (l == r){
            l++;
            r--;
        }
        if (l < right){
            quickSort(arr, l, right);
        }
        if (left < r){
            quickSort(arr, left, r);
        }
    }

    public static ArrayList<Integer> binarySearch(int[] arr,int target,int left,int right){
        int mid = (left + right) / 2;
        int value = arr[mid];
        if (left > right){
            return new ArrayList<>();
        }
        if (value > target){
            return binarySearch(arr, target, left, mid - 1);
        }else if (value < target){
            return binarySearch(arr, target, mid + 1, right);
        }else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(mid);
            //扫描相同值
            int temp1 = mid + 1;
            while (true){
                if (temp1 > arr.length || arr[temp1] != target){
                    break;
                }
                list.add(temp1);
                temp1++;
            }
            int temp2 = mid - 1;
            while (true){
                if (temp2 < 0 || arr[temp2] != target){
                    break;
                }
                list.add(temp2);
                temp2--;
            }
            return list;
        }
    }
}
