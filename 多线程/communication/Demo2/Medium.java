package 多线程.communication.Demo2;

/**
 * @Author: ruan
 * Date: 2021/7/3 21:34
 * @Description: 中间商
 */
public class Medium {
    private int num = 0;//商品库存量
    private static final int TOTAL = 20;//最大容量

    /**
     * 接收生产数据
     */
    public void put(){
        //判断当前库存是否已经是最大容量
        if (num < TOTAL){
            //如果不是，生产完成后，通知消费者进行消费
            System.out.println("新增库存----->当前库存"+ ++num);
            notifyAll();
        }else {
            //如果是,则通知生产者进行等待
            try {
                System.out.println("新增库存-----> 库存已满" + num);
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取消费数据
     */
    public void take(){
        //判断当前库存
        if (num > 0){
            //如果充足，再消费完成后通过之通知生产者生产进行生产
            System.out.println("消费库存-----> 当前库存容量"+ --num);
            notifyAll();
        }else {
            //如果不足,通知消费者暂停消费
            System.out.println("消费库存-----> 库存不足"+num);
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }

}
