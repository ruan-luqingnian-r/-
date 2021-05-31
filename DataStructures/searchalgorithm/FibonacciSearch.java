package DataStructures.searchalgorithm;

import java.util.Arrays;

/**
 * @PackgeName: DataStructures.searchalgorithm
 * @ClassName: FibonacciSearch
 * @Author: 小天才
 * Date: 2021/5/31 16:53
 * project name: 算法和数据结构
 * @Version: 0.0.1
 * @Description: 斐波那契查找
 */
public class FibonacciSearch {
    public static int maxSize = 20;
    public static void main(String[] args) {
        int[] arr = {1,8,10,89,1000,1234};
        System.out.println(fibSearch(arr,89));
    }
    //后面我们mid=low+F(k-1)-1,需要使用到斐波那契数列，因此我们需要先获取一个斐波那契数列
    public static int[] fib(){
        int [] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    /**
     *
     * @param a 数组
     * @param key 查找值
     * @return
     */
    //编写斐波那契查找算法
    public static int fibSearch(int[] a,int key){

        int low = 0;
        int high = a.length - 1;
        int k = 0;//表示斐波那契分割数值的下标
        int mid = 0;//存放mid的值
        int[] f = fib();//获取到斐波那契数列

        //获取k
        while (high > f[k] - 1){
            k++;
        }
        //因为f[k]可能大于a
        int[] temp = Arrays.copyOf(a, f[k]);//用0填充
        //实际上需要用数值的的最后值填充
        for (int i = high + 1; i < temp.length; i++) {

                temp[i] = a[high];

        }
        //使用while循环来处理，找到我的数key
        while (low <= high){
            mid = low + f[k - 1] - 1;
            if (key < temp[mid]){
                //向左查找
                high = mid - 1;
                k--;
            }else if (key > temp[mid]){
                //右边查找
                low = mid + 1;
                k -= 2;
            }else {
                //找到了
                if (mid <= high){
                    return mid;
                }else {
                    return high;
                }
            }
        }
        return -1;
    }
}
