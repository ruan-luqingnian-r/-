package 练习.java1010;

import java.util.Arrays;

/**
 * @Author: ruan
 * Date: 2021/10/10 16:14
 * @Description: 排序
 */
public class Sort {
    public static void main(String[] args) {
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 1000 + 1);
        }
        heapSort(arr);
        //quickSort(arr,0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序
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
     */
    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
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
     */
    public static void shellSort(int[] arr){
        for (int gap = (arr.length / 2); gap > 0; gap /= 2){
            for (int i = gap; i < arr.length; i++) {
                int index = i - gap;
                int value = arr[i];

                while (index >= 0 && arr[index] > value){
                    arr[index + gap] = arr[index];
                    index = index - gap;
                }
                arr[index + gap] = value;
            }
        }
    }

    /**
     * 快速排序
     */
    public static void quickSort(int[] arr){
        quick(arr,0,arr.length - 1);
    }

    private static void quick(int[] arr, int left, int right){
        int l = left;
        int r = right;
        int mid = arr[(left + right) / 2];
        while (l < r){
            while (arr[l] < mid){
                l++;
            }
            while (arr[r] > mid){
                r--;
            }
            if (l >= r){
                break;
            }
            arr[l] = arr[l] ^ arr[r];
            arr[r] = arr[r] ^ arr[l];
            arr[l] = arr[l] ^ arr[r];
            if (arr[l] == mid){
                r--;
            }
            if (arr[r] == mid){
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
     * 基数排序
     */
    public static void radixSort(int[] arr){
        //获取数组的最大位数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();
        //创建二维数组用于存放数据
        int[][] bucket = new int[10][arr.length];
        //创建一维数组用于记录桶中数据
        int[] bucketElementCount = new int[10];
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //遍历链表将对应值放入桶中
            for (int j = 0; j < arr.length; j++) {
                //取出数字中的每一位数
                int digitOfElement = arr[j] / n % 10;
                //放入到对应的桶中
                bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[j];
                //桶中对应的数据量+1
                bucketElementCount[digitOfElement]++;
            }
            //从桶中取数据放入到数组中
            int index = 0;
            //遍历桶放入原数组
            for (int k = 0; k < bucketElementCount.length; k++) {
                if (bucketElementCount[k] != 0){
                    //有数据
                    for (int l = 0; l < bucketElementCount[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }
                }
                bucketElementCount[k] = 0;
            }
        }
    }
    /**
     * 堆排序
     */
    public static void heapSort(int[] arr){
        int temp = 0;
        for (int i = arr.length / 2 - 1; i >= 0 ; i--) {
            adjustHeap(arr,i,arr.length);
        }
        for (int i = arr.length - 1; i > 0 ; i--) {
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,i);
        }
    }

    /**
     * 功能： 完成 将 以 i 对应的非叶子结点的树调整成大顶堆
     * 举例  int arr[] = {4, 6, 8, 5, 9}; => i = 1 => adjustHeap => 得到 {4, 9, 8, 5, 6}
     * @param arr 待调整的数组
     * @param i 表示非叶子结点在数组中索引
     * @param length 表示对多少个元素继续调整， length 是在逐渐的减少
     */
    private static void adjustHeap(int[] arr, int i , int length){
        //先取出当前元素，保存临时变量
        int temp = arr[i];
        //开始调整
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1){
            if (k + 1 < length && arr[k] < arr[k + 1]){
                //说明左子节点的值小于又子节点
                k++;//指向又子节点
            }
            if (arr[k] > temp){
                //子节点大于父节点
                //把较大的值赋给当前结点
                arr[i] = arr[k];
                //!!! i 指向 k,继续循环比较
                i = k;
            }else {
                break;
            }
        }
        //当for 循环结束后，我们已经将以i 为父结点的树的最大值，放在了 最顶(局部)
        arr[i] = temp;//将temp值放到调整后的位置
    }


}
