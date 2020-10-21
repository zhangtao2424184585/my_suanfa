package com.example.aaaaa.domain;

/**
 * @Classname quickSort
 * @Description TODO
 * @Date 2020/10/12 14:56
 * @Created by zhangtao
 */
public class quickSort {
    public static int fun1(int [] array , int low ,int high){
        String a = new String("123");
        String b = new String("123");
        String v = "234";
        System.out.println(a.equals(b));
        System.out.println("---------------------------------------");
        a.equals(b);
        int i = low;
        int j = high;
        int temp = array[low];
        while (i!=j){
            while (i<j&&array[j]>temp){
                j--;
            }
            if (i<j){
                array[i] = array[j];
                i++;
            }
            while (i<j&&array[i]<temp){
                i++;
            }
            if (i<j){
                array[j] = array[i];
                j--;
                array[i] = temp;
            }
        }

        array[i] = temp;
        return i;
    }

    public static void fun2(int [] array,int low,int heigh){
        if (low<heigh){
            int i = fun1(array, low, heigh);
            fun2(array,low,i-1);
            fun2(array,i+1,heigh);
        }
    }
    public static void main(String[] args) {
        int array[] = {31,78,29,10,10,96,65,10,12,46};
        fun2(array,0,array.length-1);
        for (int i : array) {
            System.out.println(i);
        }
    }
}
