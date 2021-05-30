package DataStructures.sortingalgorithm;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @PackgeName: DataStructures.sortingalgorithm
 * @ClassName: RadixSort
 * @Author: 小天才
 * Date: 2021/5/30 16:02
 * project name: 算法和数据结构
 * @Version: 0.0.1
 * @Description: 基数排序（桶排序）
 */
public class RadixSort {
    public static void main(String[] args) {
//        int[] arr = {53,3,542,748,14,214};
//        radixSort(arr);
//        System.out.println(Arrays.toString(arr));
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 800000);//[0,8000000)的随机数
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String date1Ser = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是:"+date1Ser);
        //System.out.println(Arrays.toString(arr));
        radixSort(arr);
        //System.out.println(Arrays.toString(sort));
        Date date2 = new Date();
        String date2Ser = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是:"+date2Ser);
    }

    //基数排序
    public static void radixSort(int[] arr){

        //定义一个二维数组，表示10个桶，每个桶就是一个一维数组
        int[][] bucket = new int[10][arr.length];
        //为了记录没个桶中，实际存放了多少数据，我们定义一个一维数组记录每个桶放入的数据个数
        int[] bucketElementCounts = new int[10];
        
        //得到数组中最大的位数
        int max = arr[0];//假设第一个是最大的
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max ){
                max = arr[i];
            }
        }
        //得到最大的位数
        int maxLength = (max+"").length();

        for (int i = 0,n = 1; i < maxLength; i++, n *= 10) {
            //第一轮（针对元素的个位进行处理）
            for (int j = 0; j < arr.length ; j++) {
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
                if (bucketElementCounts[k] != 0){
                    //循环该桶及第k个一维数组，放入
                    for (int l = 0; l < bucketElementCounts[k] ; l++) {
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
