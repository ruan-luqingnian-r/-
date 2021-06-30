package com.ruan.test01;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * @PackgeName: com.ruan.test01
 * @ClassName: Test01
 * @Author: 小天才
 * Date: 2021/6/30 20:27
 * project name: Data-structure-and-algorithm
 * @Version: 0.0.1
 * @Description:
 */
public class Test01 {
    public static void main(String[] args) throws UnknownHostException {
        //封装ip
        InetAddress byName1 = InetAddress.getByName("192.168.1.12");
        System.out.println(byName1);
        InetAddress localhost = InetAddress.getByName("localhost");
        System.out.println(localhost);
        InetAddress byName = InetAddress.getByName("DESKTOP-11CEJBP");
        System.out.println(byName);
        InetAddress byName2 = InetAddress.getByName("www.bbbb.com");
        System.out.println(byName2);
    }
}
