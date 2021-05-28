package recursion;

/**
 * @PackgeName: recursion
 * @ClassName: Queue8
 * @Author: 小天才
 * Date: 2021/5/28 13:54
 * project name: DataStructures
 * @Version: 0.0.1
 * @Description: 八皇后问题
 */
public class Queue8 {
    int max = 8;//定义max表示有八个皇后
    int[] array = new int[max];//定义一个数组存放结果
    static int count = 0;

    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);//开始落子
        System.out.println("共有“"+count+"”种解法");
    }


    /**
     * 落子方法
     * @param n 第n个棋子
     */
    private void check(int n){
        //结束条件
        if (n == max){
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            //先吧这个棋子放在第一列
            array[n] = i;
            //判断是否冲突
            if (isConflict(n)){
                //如果不冲突则递归；放下一个
                check(n + 1);
            }
            //如果冲突执行i++先吧这个棋子放在这一行的下一列
        }
    }

    /**
     * 判断是否冲突
     * @param n 表示放置第n个皇后
     * @return
     */
    private boolean isConflict(int n){
        //在放置第n个皇后之前应该遍历之前的皇后
        for (int i = 0; i < n; i++) {
            /**
             * 判断是否冲突
             * 1.array[i] == array[n] 表示在同一直线上
             * 2.Math.abs(n - i) == Math.abs(array[n] - array[i]) 表示在同一斜线上
             */
            if ((array[i] == array[n]) || (Math.abs(n - i) == Math.abs(array[n] - array[i]))){
                return false;
            }
        }
        return true;
    }

    /**
     * 输出皇后位置
     */
    private void print(){
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+"");
        }
        System.out.println();
    }
}
