package dataStructuresAndAlgoorithm.dataStructures.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ruan
 * Date: 2021/8/15 17:19
 * @Description: 二分查找
 */
public class Dichotomous {
    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 2, 21, 22, 31, 32, 32, 213, 312, 312, 312, 2112, 13214, 312312};
        List<Integer> dichotomous = dichotomous(arr, 1, 0, arr.length - 1);
        System.out.println(dichotomous);
    }

    /**
     * 二分查找·
     * @param arr 带查找数组
     * @param target 目标值
     * @param left 左索引
     * @param right 右索引
     * @return 数组下标
     */
    public static List<Integer> dichotomous(int[] arr, int target, int left, int right){
        int mid = (left + right) / 2;
        int midValue = arr[mid];
        //当左端点下标大于右端点下标时说明遍历结束
        if (left > right){
            return new ArrayList<>();
        }

        if (midValue > target){
            //目标值在中间值的左侧
            //向左递归
            return dichotomous(arr, target, left,mid - 1);
        }else if (midValue < target){
            //目标值在中间值的右侧
            //向右递归
            return dichotomous(arr, target, mid + 1, right);
        }else {
            //中间值就是目标值
            List<Integer> indexList = new ArrayList<>();
            indexList.add(mid);
            //防止有相同值
            //向左扫描
            int temp1 = mid - 1;
            while (true){
                //判断是否是目标
                if (temp1 < 0 || arr[temp1] != target){
                    //当索引小于0或不等于目标值时结束
                    break;
                }
                indexList.add(temp1);
                temp1--;
            }
            //向右扫描
            int temp2 = mid + 1;
            while (true){
                if (temp2 > arr.length || temp2 != target){
                    break;
                }
                indexList.add(temp2);
                temp2++;
            }
            return indexList;
        }
    }
}
