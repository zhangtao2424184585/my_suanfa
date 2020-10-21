package com.example.aaaaa.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname xiancheng
 * @Description TODO
 * @Date 2020/10/13 17:51
 * @Created by zhangtao
 */
public class xiancheng {
    public static void main(String[] args) {
        Resouce resouce = new Resouce();
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    resouce.printA();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    resouce.printB();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    resouce.printC();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

    static class Resouce {
        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();
        private Condition condition1 = lock.newCondition();
        private Condition condition2 = lock.newCondition();
        int state = 1;

        public void printA() throws InterruptedException {
            lock.lock();
            while (state != 1) {
                condition.await();
            }
            try {
                System.out.println("A");
            } finally {
                state = 2;
                condition1.signal();
                lock.unlock();
            }

        }

        public void printB() throws InterruptedException {
            lock.lock();
            while (state != 2) {
                condition1.await();
            }
            try {
                System.out.println("B");
            } finally {
                state = 3;
                condition2.signal();
                lock.unlock();
            }
        }

        public void printC() throws InterruptedException {
            lock.lock();
            while (state != 3) {
                condition2.await();
            }
            try {
                System.out.println("C");
            } finally {
                state = 1;
                condition.signal();
                lock.unlock();
            }
        }
    }

}
