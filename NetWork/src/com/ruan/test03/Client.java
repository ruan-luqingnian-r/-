package com.ruan.test03;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @PackgeName: com.ruan.test03
 * @ClassName: Client
 * @Author: 小天才
 * Date: 2021/7/1 8:04
 * project name: Data-structure-and-algorithm
 * @Version: 0.0.1
 * @Description: 客户端
 */
public class Client {
    public static void main(String[] args) throws IOException {
        //创建套接字
        Socket socket = new Socket("192.168.15.1", 8888);
        //等待用户输入账号密码
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名");
        String userName = scanner.next();
        System.out.println("请输入密码");
        String pwd = scanner.next();
        //组装用户对象
        User user = new User(userName, pwd);
        //使用对象流进行包装
        OutputStream outputStream = socket.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(user);
        //接收客户端返回的信息
        InputStream inputStream = socket.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        boolean flag = dataInputStream.readBoolean();
        if (flag){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }
        //关闭流
        outputStream.close();
        objectOutputStream.close();
        inputStream.close();
        dataInputStream.close();
        socket.close();
    }
}
