package 练习.java1027;

/**
 * @Author: ruan
 * Date: 2021/10/29 12:20
 * @Description:
 */
public class ThreadTest {
    public static void main(String[] args) {
        Thread spring = new Thread(new SeasonThreadTask("春天"));
        Thread summer = new Thread(new SeasonThreadTask("夏天"));
        Thread autumn = new Thread(new SeasonThreadTask("秋天"));
        Thread winter = new Thread(new SeasonThreadTask("冬天"));


        try {
            //春天线程先启动
            spring.start();
            //主线程等待线程spring执行完，再往下执行
            spring.join();
            //夏天线程再启动
            summer.start();
            //主线程等待线程summer执行完，再往下执行
            summer.join();
            //秋天线程最后启动
            autumn.start();
            //主线程等待线程autumn执行完，再往下执行
            autumn.join();
            //冬天线程最后启动
            winter.start();
            //主线程等待线程winter执行完，再往下执行
            winter.join();
        }catch (InterruptedException e){
        }
    }

}
class SeasonThreadTask implements Runnable{
    private String name;
    public SeasonThreadTask(String name){
        this.name = name;
    }
    @Override
    public void run() {
        for (int i = 1; i <4; i++) {
            System.out.println(this.name + "来了: " + i + "次");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

