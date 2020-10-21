package com.example.aaaaa.domain;

/**
 * @Classname Son
 * @Description TODO
 * @Date 2020/10/19 14:38
 * @Created by zhangtao
 */
public class Son extends Father {
    private static String a = "A";
    private static String b = returnb();
    static {
        System.out.println("Son"+a);
    }

    public static String returnb(){
        System.out.println("Son retrunB");
        return "B";
    }
    {
        System.out.println("Son 普通代码块");
    }
    public Son(){
        System.out.println("Son 构造");
    }
    private String c = returnC();
    public static String returnC(){
        System.out.println("Son retrunC");
        return "C";
    }


    public static void main(String[] args) {
        new Son();
    }

}
