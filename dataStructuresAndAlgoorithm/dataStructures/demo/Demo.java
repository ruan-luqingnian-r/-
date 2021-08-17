package dataStructuresAndAlgoorithm.dataStructures.demo;

import java.util.HashMap;

/**
 * @Author: ruan
 * Date: 2021/8/17 10:38
 * @Description:
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println(test1());


    }
    public static int test1() {
        int a = 1;
        try {
            System.out.println(a / 0);
            a = 2;
        } catch (ArithmeticException e) {
            a = 3;
            return a;
        } finally {
            a = 4;
        }
        return a;
    }
    public static int test2() {
        int a = 1;
        try {
            System.out.println(a / 0);
            a = 2;
        } catch (ArithmeticException e) {
            a = 3;
            return a;
        } finally {
            a = 4;
            return a;
        }
    }

}
