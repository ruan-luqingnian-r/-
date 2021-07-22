package 多线程.atomic.demo2;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @Author: ruan
 * Date: 2021/7/4 12:26
 * @Description:
 */
public class Demo1 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(arr);
        int i = atomicIntegerArray.addAndGet(1, 2);
        System.out.println(i);
        //自定义计算
        int i1 = atomicIntegerArray.accumulateAndGet(0, 2, ((left, right) ->
                left > right ? left : right
        ));

        System.out.println(i1);
    }
}
