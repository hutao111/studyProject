package org.hutao.projectservice.BIOAndNIO;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class BIOClient {
    public static void main(String[] args) throws Exception {
        while (true) {
            //1、创建client
            Socket client = new Socket("127.0.0.1", 9999);

            //2、从连接中获取输出流并发送信息
            OutputStream outputStream = client.getOutputStream();
            System.out.println("client请输入：");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            outputStream.write(s.getBytes());

            //3、从连接中取得输入流并回话
            InputStream inputStream = client.getInputStream();
            byte[] bytes = new byte[1024];
            inputStream.read(bytes);
            String hostName = client.getInetAddress().getHostName();
            System.out.println(hostName + "回复：" + new String(bytes));
            client.close();


        }

    }
}
