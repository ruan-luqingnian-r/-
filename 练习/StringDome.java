package 练习;

import java.util.Locale;

/**
 * @Author: ruan
 * Date: 2021/9/26 16:22
 * @Description: 常见类API汇总
 */
public class StringDome {
    public static void main(String[] args) {
        /**
         * 字符串
         */
        String s1 = "ABCDEABCDE";
        System.out.println("本身="+s1);
        System.out.println("length()方法---长度---" + s1.length());
        System.out.println("isEmpty()方法---判空---" + s1.isEmpty());
        System.out.println("indexOf(x)方法---字符匹配 x---"+s1.indexOf("A"));
        System.out.println("substring(x，y)方法---切割字符串---x到y-1---"+s1.substring(0, 5));
        System.out.println("equals(x)---内容比较---"+s1.equals("abcdeabcde"));
        System.out.println("equalsIgnoreCase(x)---忽略大小写的内容比较---"+s1.equalsIgnoreCase("abcdeabcde"));
        System.out.println("replace(x,y)---内容x替换为y---"+s1.replace("A","a"));
        System.out.println("toLowerCase()/toUpperCase()---内容转小/大写---"+s1.toLowerCase(Locale.forLanguageTag(s1))+"---"+s1.toUpperCase(Locale.forLanguageTag(s1)));
        System.out.println("trim()---除去空格---"+s1.trim());
        //其他类型转换
        boolean bool=Boolean.getBoolean("false");//字符串类型转换为布尔类型

        int integer=Integer.parseInt("20");//字符串类型转换为整形

        long LongInt=Long.parseLong("1024");//字符串类型转换为长整形

        float f=Float.parseFloat("1.521");//字符串类型转换为单精度浮点型

        double d=Double.parseDouble("1.52123");//字符串类型转换为双精度浮点型

    }
}
