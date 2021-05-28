package DataStructures.recursion;

/**
 * @PackgeName: DataStructures.recursion
 * @ClassName: test
 * @Author: 小天才
 * Date: 2021/5/28 11:09
 * project name: 算法和数据结构
 * @Version: 0.0.1
 * @Description:
 */
public class test {

    public static void main(String[] args) {

        System.out.println(test(3));
    }
    public static int test(int n){

        if (n == 1){
            return 1;
        }else {
            return test(n - 1) * n;
        }
    }
}
