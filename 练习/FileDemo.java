package 练习;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @Author: ruan
 * Date: 2021/10/7 9:17
 * @Description: 相关文件API练习
 */
public class FileDemo {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\阮相歌\\Desktop\\Data-structure-and-algorithm\\练习\\练习.txt");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        write(file,str);
    }


    public static void write(File file,String str){
        try(FileOutputStream fileOutputStream = new FileOutputStream(file,true);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream)
        ) {
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            bufferedOutputStream.write(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
