package com.ruan.test01;

import java.lang.reflect.Method;

/**
 * @PackgeName: com.ruan.test01
 * @ClassName: Demo
 * @Author: ruan
 * Date: 2021/7/3 9:55
 * project name: Data-structure-and-algorithm
 * @Description: 使用反射
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        //定义一个字符串，用来模拟前台支付方式
        String str = "com.ruan.test01.AliPay";//实际上就是他的全限定路径
        //下面是利用反射
        Class aClass = Class.forName(str);
        Object o = aClass.newInstance();
        Method payOnline = aClass.getMethod("payOnline");
        payOnline.invoke(o);
    }
}
