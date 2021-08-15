package dataStructuresAndAlgoorithm.dataStructures.search;

import java.util.ArrayList;

/**
 * @Author: ruan
 * Date: 2021/8/15 17:02
 * @Description: 顺序查找
 */
public class Order {
    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 2, 21, 22, 31, 32, 32, 213, 312, 312, 312, 2112, 13214, 312312};
        ArrayList<Integer> order = order(arr, 2);
        System.out.println(order);
    }

    /**
     * 顺序查找
     * @param arr 待查找数组
     * @param target 目标值
     * @return 数组下标
     */
    public static ArrayList<Integer> order(int[] arr,int target){
        /**
         * 顺序遍历数组
         */
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[0] == target){
                list.add(i);
            }
        }
        return list;
    }
}
