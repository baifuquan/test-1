package com.example.mtest.string;

import java.util.Scanner;

/**
 * @author : baifuquan
 * @date : 2022/7/7 09:45
 * @className : Test2Permutation
 * @description : 题目：输入字符串，打印出该字符串的所有排练
 **/
public class Test2Permutation {

    public static void main(String[] args) {
        String str = "";
        Scanner scan = new Scanner(System.in);
        str = scan.nextLine();
        permutation(str.toCharArray(), 0);
    }

    /**
     * 使用递归实现
     *
     * @param str
     * @param i
     * @description
     * 题目： 输入字符串，打印出该字符串的所有排练
     * 思路：首先考虑边界问题
     * 1.逐渐缩小问题的规模，并且可以用同样的方法解决子问题
     * 2.递归要有结束条件，否则会导致递归进入死循环
     */
    public static void permutation(char[] str, int i) {
        if (i >= str.length) {
            return;
        }
        if (i == str.length - 1) {
            System.out.println(String.valueOf(str));
        } else {
            for (int j = i; j < str.length; j++) {
                char temp = str[j];
                str[j] = str[i];
                str[i] = temp;
                permutation(str, i + 1);
                temp = str[j];
                str[j] = str[i];
                str[i] = temp;
            }
        }
    }
}
