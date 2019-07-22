package org.hutao.projectservice.BIOAndNIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {

    private ServerSocketChannel serverSocketChannel;
    private Selector selector;

    public NIOServer() {
        try {
            //1、得到一个serverSocketChannel对象
            serverSocketChannel = ServerSocketChannel.open();

            //2、得到一个selector对象
            selector = Selector.open();

            //3、绑定一个端口号
            serverSocketChannel.bind(new InetSocketAddress(9990));

            //4、设置非阻塞方式

            serverSocketChannel.configureBlocking(false);

            //5、注册自己到selector上
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            System.out.println("服务器准备就绪！！！");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void start() throws Exception {
        //6、开始工作
        while (true) {

            //a、监控所有的客户端

            if (selector.select(2000) == 0) {
                System.out.println("现在没有客户端连接，自己还是可以泡妞的！！！");
                continue;
            }

            //b、获取所有的客户端事件类型
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();

                if (key.isAcceptable()) {
                    System.out.println("检测到有客户端正进行连接！！！");
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                    System.out.println(socketChannel.getRemoteAddress().toString().substring(1) + "上线了！！！");


                } else if (key.isReadable()) {
                    readMsg(key);
                } else if (key.isWritable()) {

                }
                //这一步很关键，防止重复操作；
                iterator.remove();
            }
        }

    }

    public void readMsg(SelectionKey key) throws Exception {
        SocketChannel readChannel = (SocketChannel) key.channel();
        ByteBuffer byteBuffer = (ByteBuffer) key.attachment();
        int read = readChannel.read(byteBuffer);
        if (read > 0) {
            printInfo(new String(byteBuffer.array()));

            //广播消息
            String sendMsg = new String(byteBuffer.array());
            broadCast(readChannel, sendMsg);

        }
    }


    public void broadCast(SocketChannel channel, String msg) throws IOException {
        System.out.println("服务器发送了广播。。。");

        for (SelectionKey key : selector.keys()) {
            SocketChannel targetChannel = (SocketChannel) key.channel();

            if (targetChannel instanceof SocketChannel && targetChannel != channel) {
                ByteBuffer wrap = ByteBuffer.wrap(msg.getBytes());
                targetChannel.write(wrap);

            }

        }

    }

    public void printInfo(String s) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM--dd HH:mm:ss");

        System.out.println("[" + simpleDateFormat.format(new Date()) + "]" + s);
    }

    public static void main(String[] args) throws Exception {
        new NIOServer().start();
    }
}
