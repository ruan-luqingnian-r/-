package DataStructures.sortingalgorithm;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * @PackgeName: DataStructures.sortingalgorithm
 * @ClassName: bubbleSort
 * @Author: 小天才
 * Date: 2021/5/29 9:56
 * project name: 算法和数据结构
 * @Version: 0.0.1
 * @Description: 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
//        int[] arrry = {3,9,-1,10,-2};
//        System.out.println("===排序前===");
//        System.out.println(Arrays.toString(arrry));
//        int[] sort = sort(arrry);
//        System.out.println("===排序后===");
//        System.out.println(Arrays.toString(sort));
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
    public static int[] sort(int[] array){
        int temp;//作为交换的辅助遍历
        boolean flag = false;//定义标识变量表示是否进行过交换
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < (array.length - 1 - i); j++) {
                if (array[j] > array[j+1]){
                    flag = true;
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
//            System.out.println("第"+(i + 1)+"趟排序后的数组");
//            System.out.println(Arrays.toString(array));
            if (!flag){
                //没有发生过排序
                break;
            }else {
                flag = false;//重置
            }
        }
        return array;
    }
}
