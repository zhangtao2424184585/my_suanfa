package com.example.aaaaa.domain;

import java.util.concurrent.Semaphore;

/**
 * @Classname SemaphoreDemo
 * @Description TODO
 * @Date 2020/10/27 10:55
 * @Created by zhangtao
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "抢到了车位");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }

            }).start();
        }
    }
}
