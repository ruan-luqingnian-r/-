package com.ruan.test02;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @PackgeName: com.ruan.test02
 * @ClassName: TestService
 * @Author: 小天才
 * Date: 2021/6/30 22:07
 * project name: Data-structure-and-algorithm
 * @Version: 0.0.1
 * @Description: 服务端
 */
public class TestService {
    public static void main(String[] args) throws IOException {
        //1.创建套接字，指定服务端口
        ServerSocket serverSocket = new ServerSocket(8888);
        //2.等待客户端发送信息
        Socket accept = serverSocket.accept();//阻塞方法:等待接收客户端的数据，什么时候接收到数据，什么时候程序继续向下执行。返回值为socket
        //3.对于程序员来说最直观的感受是输入流
        InputStream inputStream = accept.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        //4.读取客户端发来的信息
        String str = dataInputStream.readUTF();
        System.out.println("客户端发来的消息---"+str);
        //向客户端返回信息，同样通过输出流进行操作
        OutputStream outputStream = accept.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeUTF("你好，我是服务端，我接收到你的请求了！");
        //5.关闭流
        outputStream.close();
        dataOutputStream.close();
        inputStream.close();
        dataInputStream.close();
        accept.close();
        serverSocket.close();
    }
}
