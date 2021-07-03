package com.ruan.test02;

/**
 * @PackgeName: com.ruan.test02
 * @ClassName: Test
 * @Author: ruan
 * Date: 2021/7/3 10:33
 * project name: Data-structure-and-algorithm
 * @Description: 4种方法获取字节码信息，以获取person字节码为案例
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        //1.通过getClass()方法获取字节码信息
        Person person = new Person();
        Class c1 = person.getClass();
        System.out.println(c1);
        //2.通过内置class属性
        Class c2 = Person.class;
        System.out.println(c2);
        /**
         * 方式1和方式2不常用
         * 原因：已经方式1，2需要new一个对象，可以直接操作
         */
        //3.用的最多：调用Class类提供的静态方法forName
        Class c3 = Class.forName("com.ruan.test02.Person");
        System.out.println(c3);
        //方式4：利用类的加载器(了解技能点)
        ClassLoader loader = Test.class.getClassLoader();
        Class<?> c4 = loader.loadClass("com.ruan.test02.Person");
        System.out.println(c4);
        //并且
        System.out.println(c1 == c2);
    }
}
