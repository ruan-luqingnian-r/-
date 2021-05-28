package DataStructures.sparesarray;

import java.io.*;

public class SparesArray {
    public static void main(String[] args) throws IOException {
        //创建一个原始的二维数组（11*11）
        //0表示没有棋子，1表示黑子，2表示白子
        int[][] chessArr1 = new int[11][11];
        //模拟落子
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        //输出原始的二维数组
        System.out.println("=======原始的二维数组======");
        for (int[] row : chessArr1){
            for (int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        //转化稀疏数组
        //1.先遍历原始二维数组，得到非零个数
        int sum = 0;
        for (int i = 0; i < chessArr1.length ; i++) {
            for (int j = 0; j < chessArr1.length ; j++) {
                if (chessArr1[i][j] != 0){
                    sum++;
                }
            }

        }
        System.out.println("sum"+sum);
        //2.创建稀疏数组
        int[][] sparesArray = new int[sum + 1][3];
        //3.给稀疏数组赋值
        sparesArray[0][0] = chessArr1.length;
        sparesArray[0][1] = chessArr1.length;
        sparesArray[0][2] = sum;
        //4.遍历二维数组将数据存储
        int count = 0;
        for (int i = 0; i < chessArr1.length ; i++) {
            for (int j = 0; j < chessArr1[0].length ; j++) {
                if (chessArr1[i][j] != 0){
                    count++;
                    sparesArray[count][0] = i;
                    sparesArray[count][1] = j;
                    sparesArray[count][2] = chessArr1[i][j];
                }

            }

        }

        //输出稀疏数组
        System.out.println();
        System.out.println("====得到的数组如下====");
        for (int i = 0; i < sparesArray.length ; i++) {
            System.out.printf("%d\t%d\t%d\t\n",sparesArray[i][0],sparesArray[i][1],sparesArray[i][2]);
        }

        //稀疏数组转换为二维数组
        int[][] chessArr2  = new int[sparesArray[0][0]][sparesArray[0][1]];
        for (int i = 1; i < sparesArray.length ; i++) {
            chessArr2[sparesArray[i][0]][sparesArray[i][1]] = sparesArray[i][2];
        }
        //输出转化的二维数组
        System.out.println("=======转化的二维数组======");
        for (int[] row : chessArr2){
            for (int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //将稀疏矩阵写入持久化存储设备
        File file = new File("C:\\Users\\阮相歌\\Desktop\\算法和数据结构\\src\\DataStructures\\sparesarray\\SparsArray.txt");
        FileWriter writer = new FileWriter(file);
        for (int i = 0; i <sparesArray.length ; i++) {
            for (int j = 0; j < 3 ; j++) {
                writer.write(sparesArray[i][j]+"\t");
            }
            writer.write("\r\n");
        }
        writer.close();
        //读取存储文件
        InputStream inputStream = new FileInputStream("C:\\Users\\阮相歌\\Desktop\\算法和数据结构\\src\\DataStructures\\sparesarray\\SparsArray.txt");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        byte[] bytes = new byte[bufferedInputStream.available()];
        int length;
        while ((length = bufferedInputStream.read(bytes)) != -1){
            System.out.println(new String(bytes,0,length));
        }
        bufferedInputStream.close();

    }
}
