package DataStructures.sortingalgorithm;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @PackgeName: DataStructures.sortingalgorithm
 * @ClassName: SelectionSort
 * @Author: 小天才
 * Date: 2021/5/29 19:26
 * project name: 算法和数据结构
 * @Version: 0.0.1
 * @Description: 选择排序
 */
public class SelectionSort {
    public static void main(String[] args) {
        //int[] arr = {101,34,119,1};
        //测试
        //测试排序速度
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 800000);//[0,8000000)的随机数
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String date1Ser = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是:"+date1Ser);
        //System.out.println(Arrays.toString(arr));
        int[] sort = sort(arr);
        //System.out.println(Arrays.toString(sort));
        Date date2 = new Date();
        String date2Ser = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是:"+date2Ser);
    }

    /**
     * 选择排序
     */
    public static int[] sort(int[] arr){


        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]){
                    //min不是最小的数
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
            //System.out.println("第"+i+"轮后"+ Arrays.toString(arr));
        }


        return arr;
    }
}
