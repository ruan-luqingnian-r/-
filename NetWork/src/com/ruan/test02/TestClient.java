package com.ruan.test02;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @PackgeName: com.ruan.test02
 * @ClassName: TestClient
 * @Author: 小天才
 * Date: 2021/6/30 21:58
 * project name: Data-structure-and-algorithm
 * @Version: 0.0.1
 * @Description: 客户端
 */
public class TestClient {
    public static void main(String[] args) throws IOException {
        System.out.println("请输入信息");
        Scanner scanner = new Scanner(System.in);
        String next = scanner.nextLine();
        //1.创建套接字：指定服务器的ip和端口
        Socket socket = new Socket("192.168.15.1", 8888);
        //2.对于程序员来说，向外发送数据直接使用输出流
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeUTF(next);
        //同样，从客户端接收消息同样使用输入流
        InputStream inputStream = socket.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        String str = dataInputStream.readUTF();
        System.out.println("客户端返回的消息--"+str);
        //3.关闭流关闭网络资源
        inputStream.close();
        dataInputStream.close();
        dataOutputStream.close();
        outputStream.close();
        socket.close();
    }
}
