package com.ruan.test04;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * @PackgeName: com.ruan.test04
 * @ClassName: Send
 * @Author: 小天才
 * Date: 2021/7/1 12:54
 * project name: Data-structure-and-algorithm
 * @Version: 0.0.1
 * @Description: 发送方
 */
public class Send {
    public static void main(String[] args) throws UnknownHostException {
        System.out.println("====发送方上线=====");
        InetAddress byName = InetAddress.getByName("DESKTOP-11CEJBP");
        System.out.println(byName);
        //1.准备套接字，指定发送的端口号
        DatagramSocket datagramSocket = null;
        try {
            datagramSocket = new DatagramSocket(8888);
            Scanner scanner = new Scanner(System.in);
            while (true){
                //2.准备数据包
                System.out.print("发送机:");
                String str = scanner.nextLine();
                byte[] bytes = str.getBytes();
                /**
                 * 待发送的数据包需要四个参数
                 * 1.待传输数据转为字节数组
                 * 2.字节数组的长度
                 * 3.封装接收方的ip
                 * 4.指定接收方的端口号
                 */
                DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.0.103"), 8888);//数据包
                //发送
                datagramSocket.send(datagramPacket);
                if (str.equals("beybey")){
                    System.out.println("服务下线");
                    break;
                }
                byte[] bytes1 = new byte[1024];
                DatagramPacket datagramPacket1 = new DatagramPacket(bytes1, bytes.length);
                datagramSocket.receive(datagramPacket1);
                byte[] data = datagramPacket1.getData();
                String s = new String(data, 0, datagramPacket1.getLength());
                System.out.println("服务机:" + s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭流
            datagramSocket.close();
        }
    }
}
