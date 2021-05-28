package DataStructures.recursion;

/**
 * @PackgeName: DataStructures.recursion
 * @ClassName: MiGong
 * @Author: 小天才
 * Date: 2021/5/28 12:17
 * project name: 算法和数据结构
 * @Version: 0.0.1
 * @Description: 递归解决迷宫问题
 */
public class MiGong {
    public static void main(String[] args) {
        /**
         * 二维数组模拟迷宫
         * 1表示墙
         */
        int[][] map = new int[8][7];
        //上下变为墙
        for (int i = 0; i < map[0].length; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //左右变为墙
        for (int i = 0; i < map.length; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        //设置挡板
        map[3][1] = 1;
        map[3][2] = 1;
        //输出地图
        System.out.println("迷宫地图");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j]+"");
            }
            System.out.println();
        }
        setWay(map,1,1);
        //输出走过的路径
        System.out.println("迷宫地图+走过的路径");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j]+"");
            }
            System.out.println();
        }

    }

    /**
     * 使用递归来給小球找路
     * @param map 地图
     * @param i 起点
     * @param j
     * @return 如果找到就true
     * 起点（1，1）
     * 终点（6，5）
     * 2表示通路
     * 3表示走过但是未通
     * 优先策略 ↓ → ↑ ←，如果走不同则回溯
     */
    public static boolean setWay(int[][] map,int i,int j){
        if (map[6][5] == 2){
            return true;
            //已经到达终点
        }else {
            if (map[i][j] == 0){//还未来过终点
                map[i][j] = 2;//标记路径
                //开始尝试探路优先策略 ↓ → ↑ ←
                if (setWay(map, i + 1, j)){//向↓走
                    return true;
                }else if (setWay(map, i, j + 1)){//向→走
                    return true;
                }else if (setWay(map, i - 1, j)){//向↑走
                    return true;
                }else if (setWay(map, i, j - 1)){//向←走
                    return true;
                }else {//此路不通
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }
}
