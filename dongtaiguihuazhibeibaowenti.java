package com.example.aaaaa.domain;

import java.util.*;

/**
 * zt
 * 背包问题
 */
public class dongtaiguihuazhibeibaowenti {
    public static int[][] fun(Map<Integer, Integer> map, int i, int j) {
        long time = new Date().getTime();
        int newArray[][] = new int[i][j + 1];
        Set<Integer> integers = map.keySet();
        Integer array[] = new Integer[integers.size()];
        Integer[] integers1 = integers.toArray(array);
        for (int i1 = 1; i1 < j + 1; i1++) {
            for (int i2 = 1; i2 < integers1.length; i2++) {
                if (integers1[i2] > i1) {
                    newArray[i2][i1] = newArray[i2 - 1][i1];
                } else {
                    int a = map.get(integers1[i2]) + newArray[i2 - 1][i1 - integers1[i2]];
                    int b = newArray[i2 - 1][i1];
                    newArray[i2][i1] = Math.max(a, b);
                }
            }
        }
        System.out.println(new Date().getTime()-time);
        return newArray;

    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(2, 3);
        map.put(3, 4);
        map.put(4, 5);
        map.put(5, 6);


//        Set<Integer> integers = map.keySet();
//        Object[] objects = integers.toArray();
//        for (int i = 0; i < objects.length; i++) {
//            System.out.println(objects[i]);
//        }
        StringBuffer stringBuffer = new StringBuffer();

        int[][] fun = fun(map, 5, 8);
//        System.out.println(fun[4][8]);
        for (int[] ints : fun) {
            for (int anInt : ints) {
                stringBuffer.append(anInt + ",");
            }
            stringBuffer.append("\n");
        }


        List<Integer> newList = new ArrayList<>();
        Set<Integer> integers = map.keySet();
        Integer array[] = new Integer[integers.size()];
        Integer[] integers1 = integers.toArray(array);
        System.out.println(stringBuffer.toString());
        List<Integer> list = new ArrayList<>();
        int low = 5;
        int col = 9;
        while (low > 1 && col > 1) {
            if (fun[low - 1][col - 1] != fun[low - 2][col - 1]) {
                list.add(low - 1);
                low--;
                col = col - 1 - integers1[low-1];
            } else {
                low--;
            }
        }

        System.out.println(list);
        for (Integer integer : list) {
            System.out.println(map.get(integers1[integer]));
        }


    }
}