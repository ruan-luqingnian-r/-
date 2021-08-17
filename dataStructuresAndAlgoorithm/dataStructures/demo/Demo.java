package dataStructuresAndAlgoorithm.dataStructures.demo;

import java.util.HashMap;

/**
 * @Author: ruan
 * Date: 2021/8/17 10:38
 * @Description:
 */
public class Demo {
    public static void main(String[] args) {

        System.out.println(2 << 3);
        System.out.println(40 >> 3);
        swap(31,40);
    }

    public static void swap(int a,int b){
        System.out.printf("a=%d,b=%d",a,b);
        a = a^b;
        b = b^a;
        a = a^b;
        System.out.printf("\na=%d,b=%d",a,b);
    }
}
