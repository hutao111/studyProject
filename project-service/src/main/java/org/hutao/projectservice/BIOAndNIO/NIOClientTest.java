package org.hutao.projectservice.BIOAndNIO;


import java.util.Scanner;

public class NIOClientTest {
    public static void main(String[] args) throws Exception {
        NIOClient nioClient = new NIOClient();
        new Thread(){
           public void run(){
               while (true){
                   try {
                       nioClient.recriveMsg();
                       Thread.sleep(2000);
                   } catch (Exception e) {
                       e.printStackTrace();
                   }
               }
           }
        }.start();

        Scanner scanner = new Scanner(System.in);


        while (scanner.hasNextLine()){
            String msg = scanner.nextLine();
            nioClient.sendMsg(msg);
        }
    }


}
