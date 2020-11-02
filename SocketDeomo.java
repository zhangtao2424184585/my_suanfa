package com.example.aaaaa.domain;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * @Classname SocketDeomo
 * @Description TODO
 * @Date 2020/10/30 15:00
 * @Created by zhangtao
 */
public class SocketDeomo {
    public static void start() throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(8888, 3);

        while (true) {
            System.out.println("等待链接....");
            Socket socket = serverSocket.accept();
            TimeUnit.MICROSECONDS.sleep(100);
            new Thread(new SocketThread(socket)).start();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        start();
    }


    static class WriteThread implements Runnable {
        private Socket socket;

        public WriteThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            System.out.println("为socket"+socket.getRemoteSocketAddress()+"开启写程序·····");
            OutputStream outputStream = null;
            try {
                outputStream = socket.getOutputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scanner scanner = new Scanner(System.in);
            String s = "init";
            while (!s.equals("bye")) {
                s = scanner.nextLine();
                try {
                    outputStream.write(s.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class SocketThread implements Runnable {
        private Socket socket;

        SocketThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            new Thread(new WriteThread(socket)).start();
            try {
                InputStream inputStream = socket.getInputStream();
                byte[] bytes = new byte[1024];
                int read;
                while ((read = inputStream.read(bytes)) != -1) {
                    System.out.println(socket.getInetAddress().getHostAddress() + ":" + new String(bytes, 0, read));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
