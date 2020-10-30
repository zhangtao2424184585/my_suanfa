package com.example.aaaaa.domain;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Classname ThreadPoolExcutorDemo
 * @Description TODO
 * @Date 2020/10/30 10:43
 * @Created by zhangtao
 * <p>
 * 测试死锁 然后用过 jps -l 跟jstack 来查看
 */
public class ThreadPoolExecutorDemo {
    public static void test(Object a, Object b) {
        synchronized (a) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (b) {

            }
        }
    }

    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();

        new Thread(() -> {
            test(a, b);
        }, "A").start();
        new Thread(() -> {
            test(b, a);
        }, "B").start();
    }
}
