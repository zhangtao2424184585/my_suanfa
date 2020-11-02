package com.example.aaaaa.domain;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;


/**
 * @Classname SocketClientDemo
 * @Description TODO
 * @Date 2020/10/30 15:37
 * @Created by zhangtao
 */
public class SocketClientDemo {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.25.101", 8888);
        Thread thread = new Thread(new ReadThread(socket));
        thread.start();
        OutputStream outputStream = socket.getOutputStream();
        Scanner scanner = new Scanner(System.in);
        String s = "init";
        while (!s.equals("bye")) {
            s = scanner.nextLine();
            outputStream.write(s.getBytes());
        }


    }

    static class ReadThread implements Runnable {
        private Socket socket;

        public ReadThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            System.out.println("读程序开启·····");
            InputStream inputStream = null;
            try {
                inputStream = socket.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            byte[] bytes = new byte[1024];
            int read;
            while (true) {
                try {
                    if (((read = inputStream.read(bytes)) != -1))
                        System.out.println("服务器:" + new String(bytes, 0, read));
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
