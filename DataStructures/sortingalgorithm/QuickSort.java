package DataStructures.sortingalgorithm;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @PackgeName: DataStructures.sortingalgorithm
 * @ClassName: QuickSort
 * @Author: 小天才
 * Date: 2021/5/30 11:43
 * project name: 算法和数据结构
 * @Version: 0.0.1
 * @Description: 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
//        int[] arr = {-9,78,0,23,-567,70};
//        quickSort(arr,0,arr.length - 1);
//        System.out.println(Arrays.toString(arr));
        int[] arr = new int[800000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 800000);//[0,8000000)的随机数
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Ser = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是:"+date1Ser);
        quickSort(arr,0,arr.length - 1);
        Date date2 = new Date();
        String date2Ser = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是:"+date2Ser);
    }

    /**
     * 快速排序
     * @param arr 待排序的数组
     * @param left 左端索引
     * @param right 右端索引
     */
    public static void quickSort(int[] arr,int left,int right){
        int l = left;//左索引
        int r = right;//右索引
        int pivot = arr[(left + right) / 2];//中轴
        int temp = 0;//临时变量
        //让比pivot小的值放在他的左边。
        while (l < r){
            //在pivot左边找到大于他的值
            while (arr[l] < pivot){
                l += 1;
            }
            while (arr[r] > pivot){
                r -= 1;
            }
            if (l >= r){
                break;
            }
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            //如果交换完后发现arr[l] == pivot 前移一步 r--
            if (arr[l] == pivot){
                r -= 1 ;
            }
            if (arr[r] == pivot){
                l += 1 ;
            }
        }
        //如果l==r;必须l++.r——否则回栈溢出
        if (l == r){
            l += 1;
            r -= 1;
        }
        //向左递归
        if (left < r){
            quickSort(arr, left, r);
        }
        //向右递归
        if (right > l){
            quickSort(arr, l, right);
        }
    }
}
