package com.ruan.test01;

import java.net.InetSocketAddress;

/**
 * @PackgeName: com.ruan.test01
 * @ClassName: Test02
 * @Author: 小天才
 * Date: 2021/6/30 20:47
 * project name: Data-structure-and-algorithm
 * @Version: 0.0.1
 * @Description:
 */
public class Test02 {
    public static void main(String[] args) {
        InetSocketAddress inetSocketAddress = new InetSocketAddress("192.168.15.1",8080);
        System.out.println(inetSocketAddress);
        System.out.println(inetSocketAddress.getHostName());
        System.out.println(inetSocketAddress.getPort());
    }
}
