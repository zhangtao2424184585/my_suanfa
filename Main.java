package com.example.aaaaa.domain;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * @Classname Main
 * @Description TODO
 * @Date 2020/10/12 13:32
 * @Created by zhangtao
 */
public class Main {
    public static void main(String[] args) {
        int array[] = {31,78,29,10, 10,96, 65,10,12,46};
        quickSort(array, 0, array.length-1);
        for (int i : array) {
            System.out.println(i);
        }
    }
    public static int partition(int array[], int low, int high){
        int temp=array [low] ;//用子序列的第一个作为基准
        int i=low;
        int j =high;
        while(i!=j){
            while( i<j&&array[j]>temp){
                j--;
            }
            if(i<j){
                array[i]=array[j];
                i++;
            }
            while( i<j&&array [i]<temp){
                i++;
            }
            if(i<j){
                array[j]=array[i];
                j--;
                array [i] =temp;
            }
        }
            array [i]=temp;
            return i;
        }


    public static void quickSort(int [] a,int low,int high) {
        if (low < high) {
            int i = partition(a, low, high);
            quickSort(a, low, i - 1);
            quickSort(a, i + 1, high);
        }
    }
}
