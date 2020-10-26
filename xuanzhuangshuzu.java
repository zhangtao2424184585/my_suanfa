package com.example.aaaaa.domain;

/**
 * @Classname xuanzhuangshuzu
 * @Description TODO
 * @Date 2020/10/26 10:57
 * @Created by zhangtao
 */
public class xuanzhuangshuzu {
    public static void main(String[] args) {
        int[] numbers = {2, 2, 2, 0, 1};
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = numbers[left + ((right - left) / 2)];
            if (mid > numbers[right]) {
                left = left + ((right - left) / 2) + 1;
            } else if (mid < numbers[right]) {
                right = left + ((right - left) / 2);
            } else {
                right--;
            }
        }
        System.out.println(numbers[left]);
    }
}
