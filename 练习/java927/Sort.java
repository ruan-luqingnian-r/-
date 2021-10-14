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
        //quickSort(arr,0,arr.length - 1);
        radixSort(arr);
        System.out.println("排序后:" + Arrays.toString(arr));*/

        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:sss");
        Date date1 = new Date();
        System.out.println("排序开始:" + simpleDateFormat1.format(date1));
        //quickSort(arr,0, arr.length - 1);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:sss");
        Date date2 = new Date();
        System.out.println("排序结束:" + simpleDateFormat2.format(date2));
        //quickSort(arr,0,arr.length - 1);
        radixSort(arr);
        /*ArrayList<Integer> list = binarySearch(arr, 666, 0, arr.length - 1);
        System.out.println(list.size());*/
    }
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
    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            //保存下标和变量
            int minIndex = i;
            int minValue = arr[minIndex];
            //遍历数组找到真正的最小值
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
    public static void insertionSort(int[] arr){
        //假设第一个最小
        for (int i = 1; i < arr.length; i++) {
            //保存数值和前一个下标
            int value = arr[i];
            int index = i - 1;
            //遍历之前的数据找到value的插入位置
            while (index >= 0 && value < arr[index]){
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = value;
        }
    }
    public static void shellSort(int[] arr){
        for (int gap = (arr.length / 2); gap > 0; gap /= 2){
            for (int i = gap; i < arr.length; i++){
                //保存数值和下标
                int j = i;
                int value = arr[j];
                while ((j - gap) >= 0 && arr[j - gap] > value){
                    arr[j] =  arr[j - gap];
                    j = j - gap;
                }
                arr[j] = value;
            }
        }
    }
    public static void quickSort(int[] arr,int left,int right){
        //保存相关变量
        int l = left;
        int r = right;
        int mod = arr[(left + right) / 2];
        while (l < r){

            while (arr[l] < mod){
                l++;
            }
            while (arr[r] > mod){
                r--;
            }
            if (l >= r){
                break;
            }
            //开始交换
            arr[l] = arr[l] ^ arr[r];
            arr[r] = arr[r] ^ arr[l];
            arr[l] = arr[l] ^ arr[r];
            if (arr[l] == mod){
                r--;
            }
            if (arr[r] == mod){
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

    public static void radixSort(int[] arr){
        //得到数组的最大值
        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[0]){
                maxValue = arr[i];
            }
        }
        //获取数组的最大位数是几位数
        int maxLength = (maxValue + "").length();
        //定义一个二维数组用于表示10个桶
        int[][] bucket = new int[10][arr.length];
        //定义一个一维数组用于记录桶中的数据数量
        int[] bucketElementCounts = new int[10];

        //取出数组中的每一位放入响应的桶中
        for (int i = 0,n = 1; i < maxLength; i++,n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                //获取数组的每一位数
                int digitOfElement = (arr[j] / n % 10);
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                //对应的桶中相关数量+1
                bucketElementCounts[digitOfElement]++;
            }
            //从桶中取数据放入原数组中
            int index = 0;
            //变量每个桶，如果桶中有数据则放入原数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                if (bucketElementCounts[k] != 0){
                    //循环该桶即第k个桶(即第k个一维数组)
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }
                }
                //第i+1轮处理后，需要将每个 bucketElementCounts[k] = 0 ！！！！
                bucketElementCounts[k] = 0;
            }
        }
    }

    public static ArrayList<Integer> binarySearch(int[] arr,int target,int left,int right){
        int mod = (left + right) / 2;
        int modValue = arr[mod];
        if (left > right){
            return new ArrayList<>();
        }
        if (modValue > target){
            return binarySearch(arr, target, left, mod - 1);
        }else if (modValue < target){
            return binarySearch(arr, target, mod + 1, right);
        }else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(mod);
            //扫描相同值
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
