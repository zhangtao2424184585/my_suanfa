package com.example.aaaaa.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname Kuaipaifuxi
 * @Description TODO
 * @Date 2020/10/19 14:25
 * @Created by zhangtao
 */
public class Kuaipaifuxi {
    public static int getMid(int[] array, int low, int height) {

        int temp = array[low];
        int i = low;
        int j = height;
        while (i != j) {
            while (i < j && array[j] < temp) {
                j--;
            }
            if (i < j) {
                array[i] = array[j];
                i++;
            }
            while (i < j && array[i] > temp) {
                i++;
            }
            if (i < j) {
                array[j] = array[i];
                j--;
                array[i] = temp;
            }
        }
        array[i] = temp;


        return i;
    }

    public static void quicksort(int[] array, int low, int height) {

        if (low < height) {
            int mid = getMid(array, low, height);
            quicksort(array,low,mid-1);
            quicksort(array,mid+1,height);
        }
    }

    public static void main(String[] args) {
        int array[] = {31, 78, 29, 10, 10, 96, 65, 10, 12, 46};
        quicksort(array,0,array.length-1);
        for (int i : array) {
            System.out.println(i);
        }
    }
}
