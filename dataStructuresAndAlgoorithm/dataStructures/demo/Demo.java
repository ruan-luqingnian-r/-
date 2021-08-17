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
        System.out.printf("i++=%d,++i=%d",test1(),test2());
    }

    public static void swap(int a,int b){
        System.out.printf("a=%d,b=%d",a,b);
        a = a^b; //a = a^b
        b = b^a; //b = b^a^b = a
        a = a^b; //a = a^b^a = b
        System.out.printf("\na=%d,b=%d",a,b);
    }

    public static int test1(){
        int i = 5;
        return i++;
    }
    public static int test2(){
        int i = 5;
        return ++i;
    }
}
