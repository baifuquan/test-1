package com.example.mtest.string;

import java.util.Arrays;

/**
 * @author : baifuquan
 * @date : 2022/7/7 11:22
 * @className : Test
 * @description : 交换排序
 * 题面：在只包含01的字符串中，怎样交换任意两个数的位置？最少需要交换多少次？
 * 思路：
 * 从两头往中间查看，查看过程中在左边遇到1，就和右边遇到0的交换位置，直到左边和右边相等的时候结束。
 **/
public class Test6SwapSort {

    public static void main(String[] args) {
        int count = 0;
        int[] arrays = new int[]{0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1};
        int left = 0;
        int right = arrays.length - 1;
        while (true) {
            while (arrays[left] == 0) {
                left ++;
            }
            while (arrays[right] == 1) {
                right --;
            }
            if(left >= right) {
                break;
            }else {
                int temp = arrays[left];
                arrays[left] = arrays[right];
                arrays[right] = temp;
                count ++;
            }
        }
        System.out.println("交换次数：" + count);
        System.out.println(Arrays.toString(arrays));

    }
}
