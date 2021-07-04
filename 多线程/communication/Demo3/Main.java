package 多线程.communication.Demo3;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @Author: ruan
 * Date: 2021/7/4 8:36
 * @Description:
 */
public class Main {
    public static void main(String[] args) throws IOException {
        PipedInputStream pipedInputStream = new PipedInputStream();
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        BufferedReader bufferedReader = null;

        pipedOutputStream.connect(pipedInputStream);
        new Thread(new Reader(pipedInputStream)).start();

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            pipedOutputStream.write(bufferedReader.readLine().getBytes(StandardCharsets.UTF_8));
        }finally {
            pipedOutputStream.close();
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }

    }
}
