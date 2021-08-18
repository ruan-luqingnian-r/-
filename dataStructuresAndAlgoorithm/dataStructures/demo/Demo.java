package dataStructuresAndAlgoorithm.dataStructures.demo;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author: ruan
 * Date: 2021/8/17 10:38
 * @Description:
 */
public class Demo {
    public static void main(String[] args) {

        test();

    }

    public static void test(){
        try(FileInputStream fis = new FileInputStream("C:/Users/阮相歌/Desktop/Data-structure-and-algorithm/dataStructuresAndAlgoorithm/dataStructures/demo/test.txt");
            BufferedInputStream bis = new BufferedInputStream(fis);
            FileOutputStream fos = new FileOutputStream("C:/Users/阮相歌/Desktop/Data-structure-and-algorithm/dataStructuresAndAlgoorithm/dataStructures/demo/copy.txt");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ) {
            //读取输入流
            int size;
            byte[] buf = new byte[1024];
            while ((size = bis.read(buf)) != -1){
                bos.write(buf,0,size);
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
    }




}
