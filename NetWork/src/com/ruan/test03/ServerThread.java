package com.ruan.test03;

import java.io.*;
import java.net.Socket;

/**
 * @PackgeName: com.ruan.test03
 * @ClassName: ServerThread
 * @Author: 小天才
 * Date: 2021/7/1 9:09
 * project name: Data-structure-and-algorithm
 * @Version: 0.0.1
 * @Description: 线程：专门处理客户端的请求
 */
public class ServerThread extends Thread {
    InputStream inputStream = null;
    ObjectInputStream objectInputStream = null;
    OutputStream outputStream = null;
    DataOutputStream dataOutputStream = null;
    Socket socket = null;
    public ServerThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            //获取客户端发送的信息
            inputStream = socket.getInputStream();
            objectInputStream = new ObjectInputStream(inputStream);
            User user = (User) objectInputStream.readObject();
            //进行数据校验
            boolean flag = false;
            if (user.getUsername().equals("小天才") && user.getPwd().equals("123456")){
                flag = true;
            }
            //向客户端返回信息
            outputStream = socket.getOutputStream();
            dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeBoolean(flag);
        }catch (IOException | ClassNotFoundException  e ) {
            e.printStackTrace();
        } finally {
            try {
                if (dataOutputStream != null) {
                    dataOutputStream.close();
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
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
