package com.example.aaaaa.domain;

/**
 * @Classname Father
 * @Description TODO
 * @Date 2020/10/19 14:38
 * @Created by zhangtao
 */
public class Father {
    private static String a = "A";
    private static String b = returnb();
    static {
        System.out.println("Father"+a);
    }

    public static String returnb(){
        System.out.println("Father retrunB");
        return "B";
    }
    {
        System.out.println("Father 普通代码块");
    }
    private String c = returnC();
    public static String returnC(){
        System.out.println("Father retrunC");
        return "C";
    }
    public Father (){
        System.out.println("Father 构造");
    }

    public static void main(String[] args) {
        new Father();
    }

}
