package com.ruan.test02;

/**
 * @PackgeName: com.ruan.test02
 * @ClassName: Person
 * @Author: ruan
 * Date: 2021/7/3 10:30
 * project name: Data-structure-and-algorithm
 * @Description: 作为父类
 */
public class Person {
    //属性
    public String name;
    private int age;
    //方法
    private void eat(){
        System.out.println("Person---eat");
    }
    public void sleep(){
        System.out.println("Person---sleep");
    }

}
