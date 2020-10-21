package com.example.aaaaa.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @Classname chengchanzhexiaofeizhe
 * @Description TODO
 * @Date 2020/10/12 15:42
 * @Created by zhangtao
 */
public class chengchanzhexiaofeizhe {
    public static void main(String[] args) {
        Storage storage = new Storage();
        Thread t1 = new Thread(new Privider(storage));
        Thread t2 = new Thread(new Consumer(storage));
        t1.start();
        t2.start();
    }

     static class Storage{
        private LinkedList<Integer> storages;
        private int maxSize;
        public Storage(){
            this.maxSize = 10;
            this.storages = new LinkedList<>();
        }
        public synchronized void put(){
            if (storages.size() == maxSize){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            storages.add(new Random().nextInt(1000));
            System.out.println("库存为：" + storages.size());
            notify();
        }
        public synchronized void take(){
            if (storages.size()==0){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("拿到了：" + storages.poll());
            System.out.println("还剩下：" + storages.size());
            notify();
        }
    }


    static class Privider implements Runnable{
        private Storage storage;
        public Privider(Storage storage){
            this.storage = storage;
        }
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                storage.put();
            }
        }
    }
    static class Consumer implements Runnable{
        private Storage storage;
        public Consumer(Storage storage){
            this.storage = storage;
        }


        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                storage.take();
            }


        }
    }
}
