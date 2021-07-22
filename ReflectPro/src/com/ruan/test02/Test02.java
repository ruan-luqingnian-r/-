package com.ruan.test02;

import java.lang.reflect.Field;

/**
 * @Author: ruan
 * Date: 2021/7/3 13:32
 * @Description:
 */
public class Test02 {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<Student> studentClass = Student.class;
        Field[] fields = studentClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("========");
        Field[] declaredFields = studentClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        Field score = studentClass.getField("score");
        Object o = studentClass.newInstance();
        score.set(o,99);
        System.out.println(o);
    }
}
