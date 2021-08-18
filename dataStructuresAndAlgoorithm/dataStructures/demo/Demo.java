package dataStructuresAndAlgoorithm.dataStructures.demo;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: ruan
 * Date: 2021/8/17 10:38
 * @Description:
 */
public class Demo {
    public static void main(String[] args) {
        //定义一个list用于存储目录
        List<String> paths = new ArrayList<>();
        getAllFilePast(new File("C:\\Users\\阮相歌\\Desktop\\Data-structure-and-algorithm\\dataStructuresAndAlgoorithm\\dataStructures"),paths);
        for (String path : paths){
            System.out.println(path);
        }
    }

    private static void getAllFilePast(File file, List<String> paths) {
        File[] files = file.listFiles();
        if (files == null){
            return;
        }
        for (File f : files){
            if (f.isDirectory()){
                paths.add(f.getPath());
                getAllFilePast(f,paths);
            }else {
                paths.add(f.getPath());
            }
        }
    }


}
