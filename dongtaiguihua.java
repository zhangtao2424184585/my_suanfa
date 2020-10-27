package com.example.aaaaa.domain;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Classname dongtaiguihua
 * @Description TODO
 * @Date 2020/10/20 9:38
 * @Created by zhangtao
 * <p>
 * 一个数组求不相邻元素的和为最大
 */
public class dongtaiguihua {
    //递归算法
    public static int fun1(int[] array, int n) {
        if (n == 0) {
            return array[0];
        } else if (n == 1) {
            return Math.max(array[0], array[1]);
        } else {
            int A = fun1(array, n - 1);
            int B = fun1(array, n - 2) + array[n];
            return Math.max(A, B);
        }
    }

    //动态规划算法

    public static int fun2(int[] array, int n) {
        int opt[] = new int[array.length];
        opt[0] = array[0];
        opt[1] = Math.max(array[0], array[1]);
        for (int i = 2; i < array.length; i++) {
            int a = array[i] + opt[i-2];
            int b = opt[i-1];
            opt[i] = Math.max(a,b);
        }

        return opt[n];
    }


    public static void main(String[] args) {
        int[] array = {1, 2, 4, 1, 7, 8, 3};
        System.out.println(fun1(array, array.length - 1));
        System.out.println(fun2(array, array.length - 1));
    }
}
