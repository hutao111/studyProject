package org.hutao.projectservice.BIOAndNIO;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOJava {


    //写入数据
    @Test
    public void test() throws Exception {
        //1、创建输出流
        FileOutputStream fileOutputStream = new FileOutputStream("taoge.txt");

        //2、从流中获取一个通道
        FileChannel fileChannel = fileOutputStream.getChannel();

        //3、提供一个缓存区，初始化一个大小为1024字节的缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //4、往缓冲区内放数据
        byteBuffer.put("涛哥贼帅".getBytes());


        //5、翻转缓冲区，把读取数据的指针初始化到刚开始的位置，否则会读取不到数据
        byteBuffer.flip();

        //6、把缓冲区写入到通道中
        fileChannel.write(byteBuffer);
        fileOutputStream.close();
    }

    @Test  //读取某文件的信息
    public void test2()throws Exception{
        File file = new File("taoge.txt");
        FileInputStream fileInputStream = new FileInputStream(file);

        FileChannel channel = fileInputStream.getChannel();


        ByteBuffer byteBuffer =  ByteBuffer.allocate((int)file.length());

        channel.read(byteBuffer);

        System.out.println(new String( byteBuffer.array()));
        fileInputStream.close();

    }

    @Test    //copy文件
    public void test3()throws  Exception{
        File file = new File("taoge.txt");
        FileInputStream inputStream = new FileInputStream(file);
        FileOutputStream outputStream = new FileOutputStream("d://taoge1.txt");

        FileChannel channel = inputStream.getChannel();
        FileChannel channel2 = outputStream.getChannel();

//        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        channel2.transferFrom(channel,0,file.length());
        outputStream.close();
        inputStream.close();


    }


}
