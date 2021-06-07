package DataStructures.tree;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @PackgeName: DataStructures.tree
 * @ClassName: HeapSort
 * @Author: 小天才
 * Date: 2021/6/7 12:32
 * project name: 算法和数据结构
 * @Version: 0.0.1
 * @Description: 堆排序
 */
public class HeapSort {
    public static void main(String[] args) {
//        int[] arr = {4,6,8,5,9};
//        heapSort(arr);
        //测试排序速度
        int[] arr = new int[8000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 800000);//[0,8000000)的随机数
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String date1Ser = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是:"+date1Ser);
        //System.out.println(Arrays.toString(arr));
       heapSort(arr);
        //System.out.println(Arrays.toString(sort));
        Date date2 = new Date();
        String date2Ser = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是:"+date2Ser);
    }
    /**
     * 堆排序
     */
    public static void heapSort(int[] arr){
        int temp = 0;
        for (int i = arr.length / 2 - 1; i > 0; i--) {
            adjustHeap(arr,i,arr.length);
        }
        //交换
        for (int i = arr.length - 1; i > 0; i--) {
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
        }
        //System.out.println(Arrays.toString(arr));
    }
    //将一共数组调整成大顶堆
    public static void adjustHeap(int[] arr,int i,int length){
        //取出当前元素的值并将其保存
        int temp = arr[i];

        //k = (i * 2 + 1)是i的左子节点
        for (int k = (i * 2 + 1); k < length; k = (k * 2 + 1)){
            if (k + 1 < length && arr[k] < arr[k+1]){
                //左子节点小于右子节点
                k++;//指向右子节点
            }
            if (arr[k] > temp){
                //如果子节点大于父节点则交换
                arr[i] = arr[k];
                i = k;//!!!!让k继续循环比较
            }else {
                break;
            }
        }
        //当循环结束后i为父节点的最大数
        arr[i] = temp;
    }
}
