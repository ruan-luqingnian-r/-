package 多线程.atomic.demo1;

import java.util.concurrent.atomic.LongAccumulator;

/**
 * @Author: ruan
 * Date: 2021/7/4 12:20
 * @Description:
 */
public class Demo2 {
    public static void main(String[] args) {
        LongAccumulator longAccumulator = new LongAccumulator((left,right)->
                left > right ? left : right,0L
                );
        longAccumulator.accumulate(3l);
        System.out.println(longAccumulator.get());
    }
}
