package com.ruan.test03;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @PackgeName: com.ruan.test03
 * @ClassName: Service
 * @Author: 小天才
 * Date: 2021/7/1 8:20
 * project name: Data-structure-and-algorithm
 * @Version: 0.0.1
 * @Description: 服务端
 */
public class Service {
    public static void main(String[] args) {
        //创建套接字
        ServerSocket serverSocket = null;
        Socket accept = null;
        int count = 0;//计数器
        try {
            serverSocket = new ServerSocket(8888);
            //等待接收数据
            while (true){
                accept = serverSocket.accept(); //服务器一直监听客户端
                new ServerThread(accept).start();
                count++;
                System.out.println("当前第"+count+"个用户正在访问，用户对象为"+serverSocket.accept().getInetAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
