package org.hutao.projectservice.BIOAndNIO;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

//网络NIO 编程
public class NIOClient {
    private final String HOST = "127.0.0.1";
    private String name = null;
    private int PORT = 9990;
    private SocketChannel clientChannel;

    public NIOClient() throws Exception {
        //1、得到一个网络通道
        clientChannel = SocketChannel.open();

        //2、设置非阻塞方式
        clientChannel.configureBlocking(false);

        //3、提供服务器的IP地址和端口号
        InetSocketAddress address = new InetSocketAddress(HOST, PORT);

        //4、链接服务器

        if (!clientChannel.connect(address)) {
            while (!clientChannel.finishConnect()) {
                System.out.println("client:我不仅可以链接服务器，还可以蹦迪！！！");
            }
        }

        name = clientChannel.getLocalAddress().toString();
        System.out.println("-----------------client (" + name + ") is ready");
    }

    public void sendMsg(String msg) throws Exception {

        msg = name + "说：" + msg;
        ByteBuffer byteBuffer = ByteBuffer.wrap(msg.getBytes());
        clientChannel.write(byteBuffer);

        if (msg.equalsIgnoreCase("bye")) {
            clientChannel.close();
            return;
        }
    }

    public void recriveMsg() throws Exception {
        //5、得到缓冲区

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        int read = clientChannel.read(byteBuffer);

        if (read > 0) {
            System.out.println(new String(byteBuffer.array()).trim());
        }
        //另类方式阻止client结束，防止服务器端抛出异常
        System.in.read();

    }
}
