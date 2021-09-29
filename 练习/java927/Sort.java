package 练习.java927;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author: ruan
 * Date: 2021/9/27 16:19
 * @Description: 排序算法
 */
public class Sort {
    public static void main(String[] args) {
        int[] arr = new int[8000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 1000 + 1);
        }
        /*System.out.println("排序前:" + Arrays.toString(arr));
        quickSort(arr,0,arr.length - 1);
        System.out.println("排序后:" + Arrays.toString(arr));*/

        /*SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:sss");
        Date date1 = new Date();
        System.out.println("排序开始:" + simpleDateFormat.format(date1));
        insertionSort(arr);
        Date date2 = new Date();
        System.out.println("排序结束:" + simpleDateFormat.format(date2));*/
        quickSort(arr,0,arr.length - 1);
        ArrayList<Integer> list = binarySearch(arr, 666, 0, arr.length - 1);
        System.out.println(list.size());
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

    public static void quickSort(int[] arr,int left,int right){
        int l = left;
        int r = right;
        int value = arr[(left + right) / 2];
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
            arr[l] = arr[l] ^ arr[r];
            arr[r] = arr[r] ^ arr[l];
            arr[l] = arr[l] ^ arr[r];
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
        if (l < right){
            quickSort(arr, l, right);
        }
        if (left < r){
            quickSort(arr, left, r);
        }

    }

    public static ArrayList<Integer> binarySearch(int[] arr,int target,int left,int right){
        int mod = (left + right) / 2;
        int value = arr[mod];
        if (left > right){
            return new ArrayList<>();
        }
        if (value > target){
            return binarySearch(arr, target, left, mod - 1);
        }else if (value < target){
            return binarySearch(arr, target, mod + 1, right);
        }else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(mod);
            int temp1 = mod + 1;
            while (true){
                if (temp1 > arr.length || arr[temp1] != target){
                    break;
                }
                list.add(temp1);
                temp1++;
            }
            int temp2 = mod - 1;
            while (true){
                if (temp1 < 0 || arr[temp1] != target){
                    break;
                }
                list.add(temp1);
                temp1--;
            }
            return list;
        }
    }


}
