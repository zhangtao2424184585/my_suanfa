package com.example.aaaaa.domain;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Classname CountDownLatch
 * @Description TODO
 * @Date 2020/10/27 10:29
 * @Created by zhangtao
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);


        for (int i = 0; i < 3; i++) {
            new Thread(() -> {

                System.out.println(Thread.currentThread().getName() + "结束");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }

        countDownLatch.await();
        System.out.println("main结束");
    }
}
