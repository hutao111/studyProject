package org.hutao.projectservice.BIOAndNIO;

import javax.mail.internet.InternetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

//网络NIO 编程
public class NIOClient {

    public static void main(String[] args) throws Exception {

        //1、得到一个网络通道
        SocketChannel clentChannel = SocketChannel.open();

        //2、设置非阻塞方式
        clentChannel.configureBlocking(false);

        //3、提供服务器的IP地址和端口号
        InetSocketAddress address = new InetSocketAddress("127.0.0.1",9990);

        //4、链接服务器

        if (!clentChannel.connect(address)){
            while (!clentChannel.finishConnect()){
                System.out.println("client:我不仅可以链接服务器，还可以蹦迪！！！");
            }
        }



        System.out.println();
        //5、得到缓冲区



        String sendMsg = "晒呀";
        ByteBuffer byteBuffer = ByteBuffer.wrap(sendMsg.getBytes());
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(1024);
        clentChannel.read(byteBuffer);
        System.out.println(new String(byteBuffer1.array()));

        //6、写入数据
        clentChannel.write(byteBuffer);



        //另类方式阻止client结束，防止服务器端抛出异常
        System.in.read();
    }
}
