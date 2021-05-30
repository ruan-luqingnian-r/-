package DataStructures.sortingalgorithm;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @PackgeName: DataStructures.sortingalgorithm
 * @ClassName: InsertSort
 * @Author: 小天才
 * Date: 2021/5/30 9:45
 * project name: 算法和数据结构
 * @Version: 0.0.1
 * @Description: 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
//        int[] arr = {101,34,119,1};
//        System.out.println(Arrays.toString(sort(arr)));
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 800000);//[0,8000000)的随机数
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String date1Ser = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是:"+date1Ser);
        int[] sort = sort(arr);
        Date date2 = new Date();
        String date2Ser = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是:"+date2Ser);
    }

    public static int[] sort(int[] arr){


        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];//定义待插入的数字
            int insertIndex = i - 1;//arr[1]前的下标
            while (insertIndex >= 0 && arr[insertIndex] > insertVal ){
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }

            arr[insertIndex + 1] = insertVal;
            //System.out.println("第"+i+"次排序结果:"+Arrays.toString(arr));
        }

        return arr;
    }
}
