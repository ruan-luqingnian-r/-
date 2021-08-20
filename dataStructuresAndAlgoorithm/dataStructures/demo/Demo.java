package dataStructuresAndAlgoorithm.dataStructures.demo;

import java.io.*;
import java.util.*;

/**
 * @Author: ruan
 * Date: 2021/8/17 10:38
 * @Description:
 */
public class Demo {
    public static void main(String[] args) {
        /*//定义一个list用于存储目录
        List<String> paths = new ArrayList<>();
        getAllFilePast(new File("C:\\Users\\阮相歌\\Desktop\\Data-structure-and-algorithm\\dataStructuresAndAlgoorithm\\dataStructures"),paths);
        for (String path : paths){
            System.out.println(path);
        }
        List<Object> objects = Collections.synchronizedList(new ArrayList<>());*/
        int[] arr = {12,31,42,3,42,123,42,324,45,25,6,325,643,4,32545,65,34,21,12,3};
        quick(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void getAllFilePast(File file, List<String> paths) {
        File[] files = file.listFiles();
        if (files == null){
            return;
        }
        for (File f : files){
            if (f.isDirectory()){
                paths.add(f.getPath());
                getAllFilePast(f,paths);
            }else {
                paths.add(f.getPath());
            }
        }
    }

    /**
     * 希尔排序
     * @param arr
     */
    private static void shell(int[] arr){
        //分成两组
        for (int gap = arr.length / 2;gap > 0;gap /= 2){
            for (int i = gap;i < arr.length;i++){
                //保存下标和待插入数据
                int j = i;
                int value = arr[j];
                if (arr[j] < arr[j - gap]){
                    while (j - gap >= 0 && arr[j] < arr[j - gap]){
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = value;
                }

            }
        }

    }

    /**
     * 希尔排序
     */
    public static void shellSort(int[] arr){
        for (int gap = arr.length / 2;gap > 0;gap /= 2){
            for (int i = gap;i < arr.length;i++){
                //保存下标和待插入数据
                int j = i;
                int value = arr[j];
                if (arr[j - gap] > arr[j]){
                    while ((j - gap) >= 0 && arr[j - gap] > arr[j]){
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = value;
                }
            }
        }
    }

    /**
     * 快速排序
     * @param arr
     * @param left
     * @param right
     */
    public static void quick(int[] arr,int left,int right){
        //保存下标和相关数据
        int l = left;
        int r = right;
        int midValue = arr[(left + right) / 2];
        int temp = 0;
        while (l < r){
            while (arr[l] < midValue){
                l++;
            }
            while (arr[r] > midValue){
                r--;
            }
            if (l >= r){
                break;
            }
            //开始交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == midValue){
                r--;
            }
            if (arr[r] == midValue){
                l++;
            }
        }
        if (l == r){
            l++;
            r--;
        }
        if (r > left){
            quick(arr, left, r);
        }
        if (right > l){
            quick(arr, l, right);
        }
    }


}
