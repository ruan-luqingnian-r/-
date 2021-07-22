package com.ruan.test02;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author: ruan
 * Date: 2021/7/3 12:57
 * @Description:
 */
public class Test01  {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //获取字节码信息
        Class studentClass = Student.class;

        //通过字节码信息获取构造器
        System.out.println("======getConstructors()方法获取的构造器======");
        Constructor[] constructors = studentClass.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("==========================================");
        System.out.println("======getDeclaredConstructors()方法获取的构造器======");
        Constructor[] declaredConstructors = studentClass.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
        System.out.println("==========================================");

        //获取指定的构造器
        Constructor constructor = studentClass.getConstructor();
        System.out.println(constructor);
        //有了构造器之后就可以创建对象了
        Object o = constructor.newInstance();
        System.out.println(o);
        Object o1 = studentClass.newInstance();
        System.out.println(o1);
    }
}
