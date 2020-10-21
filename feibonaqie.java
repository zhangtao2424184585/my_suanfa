package com.example.aaaaa.domain;

/**
 * @Classname feibonaqie
 * @Description TODO
 * @Date 2020/10/19 15:55
 * @Created by zhangtao
 */
public class feibonaqie {
    public static int fun1(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fun1(n - 1) + fun1(n - 2);
        }
    }

    public static int fun2(int n) {

        if (0 == n || 1 == n)
            return 1;
        int num1 = 1;
        int num2 = 1;
        int count = 2;
        while (count++ <= n) {
            int tmp = num1;
            num1 = num2;
            num2 = (tmp + num2) % 1000000007;
        }
        return num2;


    }


    public static int fun3(int n) {

        if (0 == n || 1 == n)
            return 1;
        int temp = 0;
        int num1 = 1;
        int num2 = 1;
        while (n - 1 != 0) {
            temp = num2;
            num2 = num1 + num2;
            num1 = temp;
            n--;
        }
        return num2;


    }


    public static void main(String[] args) {
        System.out.println(fun3(6));
    }
}
