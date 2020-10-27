package com.example.aaaaa.domain;

/**
 * @Classname Test
 * @Description TODO
 * @Date 2020/10/21 14:25
 * @Created by zhangtao
 */
public class Test {
    public static boolean fun() {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int temp = 0;
        int initn = 0;
        int initm = m - 1;
        while (initn < n && initm >= 0) {
            int flag = matrix[initn][initm];
            if (flag > 5) {

                initm--;
            } else if (flag < 5) {
                initn++;
            } else {
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(fun());
    }
}
