package com.ruan.test04;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;

/**
 * @PackgeName: com.ruan.test04
 * @ClassName: Receive
 * @Author: 小天才
 * Date: 2021/7/1 13:11
 * project name: Data-structure-and-algorithm
 * @Version: 0.0.1
 * @Description: 接收方
 */
public class Receive {
    public static void main(String[] args) throws IOException {
        System.out.println("====接收方上线====");
        //准备套接字,指定接收端口

        while (true) {
            DatagramSocket datagramSocket = new DatagramSocket(9999);
            Scanner scanner = new Scanner(System.in);
            //创建一个空数据包用于接收数据
            byte[] bytes = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);//空数据包
            //接收数据,并将数据写入数据包
            datagramSocket.receive(datagramPacket);
            //读取数据
            byte[] data = datagramPacket.getData();
            String s = new String(data, 0, datagramPacket.getLength());
            System.out.println("发送机：" + s);
            //回复信息
            String str = scanner.nextLine();
            byte[] bytes1 = str.getBytes();
            DatagramPacket localhost = new DatagramPacket(bytes1, bytes1.length, InetAddress.getByName("localhost"), 8888);
            datagramSocket.send(localhost);
            datagramSocket.close();
        }
    }
}
