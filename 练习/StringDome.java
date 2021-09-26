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

        /**
         * Math类
         */

        //计算平方根
        System.out.println(Math.sqrt(16));

        //计算立方根
        System.out.println(Math.cbrt(8));
    
        //两个数的最大，支持int，1ong，float，double 
        System.out.println(Math.max(2.9,4.5));
        System.out.println(Math.min(2.9,4.5));

        //cei1向上取整，更大的值方向靠拢，中文是天花板
        System.out.println(Math.ceil(19.7));System.out.println(Math.ceil(-20.1));

        //f1oor向下取整，更小的值方向靠拢
        System.out.println(Math.floor(19.7));System.out.println(Math.floor(-20.1));

        //随机数
        System.out.println(Math.random());//小于1大于0的double类型的数

        //产生1到10的随机数，int方法进行转换它会去掉小数掉后面的数字即只获取整数部分，不是四舍五入
        int random=(int)(Math.random()*10+1);

    }
}
