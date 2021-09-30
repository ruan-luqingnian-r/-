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
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:sss");
        Date date1 = new Date();
        System.out.println("排序开始:" + simpleDateFormat1.format(date1));
        radixSort1(arr);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:sss");
        Date date2 = new Date();
        System.out.println("排序结束:" + simpleDateFormat2.format(date2));
        //System.out.println("排序后:" + Arrays.toString(arr));
        /*ArrayList<Integer> list = binarySearch(arr, 66, 0, arr.length);
        System.out.println(list.size());*/
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

    /**
     * 基数排序
     * @param arr
     */
    public static void radixSort(int[] arr){
        //定义一个二位数组用来表示10个桶,每个桶表示一个数组
        int[][] bucket = new int[10][arr.length];
        //为了定义记录桶中的数量，定义一个一维数组记录每个bucket中的数据数量
        int[] bucketElementCounts = new int[10];
        //首先找到数组中的最大值
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        //判断最大数的位数
        int maxLength = (max + "").length();

        for (int i = 0,n = 1; i < maxLength; i++,n *= 10) {
            //第一轮根据个位进行处理
            for (int j = 0; j < arr.length; j++) {
                int digitofElement  = arr[j] / n % 10;
                //放入对应的桶中
                bucket[digitofElement][bucketElementCounts[digitofElement]] = arr[j];
                bucketElementCounts[digitofElement]++;
            }
            //按照桶的顺序（一维数组的下标依次取出数据，放入原来的数组中）
            int index = 0;
            //遍历桶中的每一个元素放入原数组中
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中有数据才放入
                if (bucketElementCounts[k] != 0){
                    //循环该桶及第k个一维数组，放入
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        //取出元素
                        arr[index] = bucket[k][l];
                        index++;
                    }
                }
                //第一轮处理后bucketElementCounts[k] = 0;!!!!
                bucketElementCounts[k] = 0;
            }
        }
    }

    public static void radixSort1(int[] arr) {

        //定义一个二维数组，表示10个桶，每个桶就是一个一维数组
        int[][] bucket = new int[10][arr.length];
        //为了记录没个桶中，实际存放了多少数据，我们定义一个一维数组记录每个桶放入的数据个数
        int[] bucketElementCounts = new int[10];

        //得到数组中最大的位数
        int max = arr[0];//假设第一个是最大的
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //得到最大的位数
        int maxLength = (max + "").length();

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //第一轮（针对元素的个位进行处理）
            for (int j = 0; j < arr.length; j++) {
                //取出元素的个位
                int digitofElement = arr[j] / n % 10;
                //放入到对应的桶
                bucket[digitofElement][bucketElementCounts[digitofElement]] = arr[j];
                bucketElementCounts[digitofElement]++;
            }
            //按照桶的顺序（一维数组的下标依次取出数据，放入原来的数组中）
            int index = 0;
            //遍历每一个桶讲桶中的元素放入原数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中有数据才放入
                if (bucketElementCounts[k] != 0) {
                    //循环该桶及第k个一维数组，放入
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        //取出元素放入arr
                        arr[index] = bucket[k][l];
                        index++;
                    }
                }
                //第一轮处理后bucketElementCounts[k] = 0;!!!!
                bucketElementCounts[k] = 0;
            }
        }
    }
}
