package DataStructures.sortingalgorithm;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @PackgeName: DataStructures.sortingalgorithm
 * @ClassName: ShellSort
 * @Author: 小天才
 * Date: 2021/gap/30 10:2gap
 * project name: 算法和数据结构
 * @Version: 0.0.1
 * @Description: 希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {
//        int[] arr = {8,9,1,7,2,3,5,4,6,0};
//        exchangeSort(arr);
        int[] arr = new int[800000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 800000);//[0,8000000)的随机数
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Ser = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是:"+date1Ser);
        moveSort(arr);
        Date date2 = new Date();
        String date2Ser = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是:"+date2Ser);
    }

    /**
     * 希尔排序交换法
     * @param arr
     * @return
     */
    public static int[] exchangeSort(int[] arr){
        int temp = 0;
        int count = 1;
        for (int gap = arr.length / 2; gap > 0  ; gap /= 2) {
            for (int i = gap; i < arr.length ; i++) {
                for (int j = i - gap; j >= 0 ; j -= gap) {
                    if (arr[j] > arr[j + gap]){
                        temp = arr[j];
                        arr [j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            //System.out.println("第"+count+++"次希尔排序:"+ Arrays.toString(arr));
        }
        return arr;
    }

    /**
     * 移动法
     * @param arr
     * @return
     */
    public static int[] moveSort(int[] arr){

        for (int gap = arr.length / 2; gap > 0 ; gap /= 2) {
            //从第gap个元素，逐步对所在的组进行插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;//保存下标
                int temp = arr[j];//待插入的数字
                if (arr[j] < arr[j - gap]){
                    while (j - gap >= 0 && temp < arr[j - gap]){
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //当退出循环后找到位置
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }

}
