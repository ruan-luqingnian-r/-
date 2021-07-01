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
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //创建套接字
        ServerSocket serverSocket = new ServerSocket(8888);
        //等待接收数据
        Socket accept = serverSocket.accept();
        //获取客户端发送的信息
        InputStream inputStream = accept.getInputStream();
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        User user = (User) objectInputStream.readObject();
        //进行数据校验
        boolean flag = false;
        if (user.getUsername().equals("小天才") && user.getPwd().equals("123456")){
            flag = true;
        }
        //向客户端返回信息
        OutputStream outputStream = accept.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeBoolean(flag);
        //关闭流
        inputStream.close();
        objectInputStream.close();
        outputStream.close();
        dataOutputStream.close();
        accept.close();
        serverSocket.close();

    }
}
