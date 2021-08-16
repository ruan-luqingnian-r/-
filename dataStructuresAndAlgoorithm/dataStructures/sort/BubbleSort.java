package dataStructuresAndAlgoorithm.dataStructures.sort;

import java.util.Arrays;

/**
 * @Author: ruan
 * Date: 2021/7/21 20:02
 * @Description: 冒泡排序
 * 从第一个开始，和之后的逐一进行比较，进行换位
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {12,31,42,3,42,123,42,324,45,25,6,325,643,4,32545,65,34,21,12,3};
        int[] sort = sort(arr);
        System.out.println(Arrays.toString(sort));
    }

    /**
     * 冒泡排序
     * @param arr 待排序数组
     * @return 排序好的数组
     * 时间复杂度O(n^2)
     */
    public static int[] sort(int[] arr){
        int temp = 0;
        //判断是否进行交换
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j+1]){
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if (!flag){
                //如果没有交换则直接跳出当前循环
                break;
            }else {
                //重置flag
                flag = false;
            }
        }
        return arr;
    }
}
