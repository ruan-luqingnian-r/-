package 多线程.communication.Demo3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.nio.Buffer;
import java.util.stream.Collectors;

/**
 * @Author: ruan
 * Date: 2021/7/3 22:26
 * @Description:
 */
public class Reader implements Runnable{
    private PipedInputStream pipedInputStream;

    public Reader(PipedInputStream pipedInputStream) {
        this.pipedInputStream = pipedInputStream;
    }

    @Override
    public void run() {

        if (pipedInputStream != null){
            String collect = new BufferedReader(new InputStreamReader(pipedInputStream)).lines().collect(Collectors.joining("\n"));
            System.out.println(Thread.currentThread().getName()+":"+collect);
        }
        try {
            pipedInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
