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
        InputStream inputStream = null;
        ObjectInputStream objectInputStream = null;
        OutputStream outputStream = null;
        DataOutputStream dataOutputStream = null;
        try {
            serverSocket = new ServerSocket(8888);
            //等待接收数据
            accept = serverSocket.accept();
            //获取客户端发送的信息
            inputStream = accept.getInputStream();
            objectInputStream = new ObjectInputStream(inputStream);
            User user = (User) objectInputStream.readObject();
            //进行数据校验
            boolean flag = false;
            if (user.getUsername().equals("小天才") && user.getPwd().equals("123456")){
                flag = true;
            }
            //向客户端返回信息
            outputStream = accept.getOutputStream();
            dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeBoolean(flag);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
            if (objectInputStream != null) {
                    objectInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (dataOutputStream != null) {
                    dataOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (accept != null){
                    accept.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
