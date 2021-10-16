/**
 * @Author: ruan
 * Date: 2021/10/15 17:04
 * @Description:
 */
import java.util.*;
class Main{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int score[] = new int[n];
        for (int i = 0; i < score.length; i++) {
            score[i] = scanner.nextInt();
        }
        //对分数进行排序
        Arrays.sort(score);
        //淘汰人数
        int out = n - y;
        if (out > y){
            System.out.println(-1);
        }else if (out >= x && out <= y){
            System.out.println(score[n-y-1]);
        }else{
            System.out.println(score[x-1]);
        }

    }
}
