package com.example.aaaaa.domain;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Classname MySingleton
 * @Description TODO
 * @Date 2020/10/15 14:19
 * @Created by zhangtao
 */
public class MySingleton {
    private static MySingleton instance = null;

    private MySingleton() {
    }

    public static MySingleton getInstance() {
        synchronized (MySingleton.class) {
            if (instance == null) {
                instance = new MySingleton();
                return instance;
            }
            return instance;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 8, 9, 1, 3};
        char s = 'A';
        int b = s;
        int c = 65;
        char d = (char) c;

        System.out.println('a' + 0);

    }
}
