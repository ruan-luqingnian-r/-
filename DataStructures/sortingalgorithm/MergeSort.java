package DataStructures.sortingalgorithm;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @PackgeName: DataStructures.sortingalgorithm
 * @ClassName: MergeSort
 * @Author: 小天才
 * Date: 2021/5/30 15:13
 * project name: 算法和数据结构
 * @Version: 0.0.1
 * @Description: 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
//        int[] arr = {8,4,5,7,1,3,6,2};
//        int[] temp = new int[arr.length];
//        mergeSort(arr,0,arr.length - 1,temp);
//        System.out.println("归并后的数组:"+ Arrays.toString(arr));
        int[] arr = new int[800000];
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 800000);//[0,8000000)的随机数
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Ser = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是:"+date1Ser);
        mergeSort(arr,0,arr.length - 1,temp);
        Date date2 = new Date();
        String date2Ser = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是:"+date2Ser);
    }

    //分+合的方法
    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        if (left < right){
            int mid = (left + right) / 2;//中间的索引
            //向左递归进行分解
            mergeSort(arr, left, mid, temp);
            //向右递归进行分解
            mergeSort(arr, mid + 1, right, temp);
            //合并
            merge(arr,left,mid,right,temp);
        }
    }

    //合并的方法
    /**
     *
     * @param arr 待排序的数组
     * @param left 左边有序序列的初始索引
     * @param mid 中间索引
     * @param right 右边有序序列的索引
     * @param temp 中转索引
     */
    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;//初始化，左边有序序列的初始索引
        int j = mid + 1;//初始化,右边有序序列的初始化索引
        int t = 0;//指向temp数组的当前索引

        //先把左右两边的数据按规则填充到temp数组
        //直到有一方处理完毕
        while (i <= mid && j <= right){//go on
            //如果左边有序序列的当前元素小于右边的
            if (arr[i] <= arr[j]){
                temp[t] = arr[i];
                t += 1;
                i += 1;
            }else {
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }
        //把剩余一方的数字全部添入
        while (i <= mid){//左边序列还有剩余,全部填入
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }
        while (j <= right){
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }
        //将temp数组的元素全部拷贝到arr
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right){
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }
}
