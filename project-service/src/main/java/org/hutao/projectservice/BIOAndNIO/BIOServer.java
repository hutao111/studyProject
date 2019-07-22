package org.hutao.projectservice.BIOAndNIO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class BIOServer {
    public static void main(String[] args) throws IOException {
        //1、创建serverSocket对象
        ServerSocket serverSocket = new ServerSocket(9999);

        while (true) {

            //2、监听客户端
            Socket socket = serverSocket.accept();

            //3、从客户端读取数据
            InputStream inputStream = socket.getInputStream();

            byte[] bytes = new byte[1024];

            Integer clinetIP = socket.getPort();
            inputStream.read(bytes);
            System.out.println(clinetIP + "说：" + new String(bytes));
            OutputStream outputStream = socket.getOutputStream();
            byte[] msg = "你好帅".getBytes();
            outputStream.write(msg);
            socket.close();

        }
        //
    }
}
