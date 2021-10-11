package 练习.java1010;

/**
 * @Author: ruan
 * Date: 2021/10/10 9:59
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        String a = "abc";
        String b = "abc";
        System.out.println(a==b);
        String c = new String("abc");
        System.out.println(a==c);
        System.out.println(a==c.intern());
    }
}
