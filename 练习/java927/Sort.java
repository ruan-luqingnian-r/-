package 练习.java927;


import java.util.Arrays;

/**
 * @Author: ruan
 * Date: 2021/9/27 16:19
 * @Description: 排序算法
 */
public class Sort {
    public static void main(String[] args) {
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 1000 + 1);
        }
        System.out.println("排序前:" + Arrays.toString(arr));
        System.out.println("排序后:" + Arrays.toString(arr));
    }



}
