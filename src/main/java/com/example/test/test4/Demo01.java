package com.example.test.test4;

import java.util.Scanner;

/**
 * @author : baifuquan
 * @date : 2022/6/20 15:37
 * @className : Demo01
 * @description : Demo01
 **/
public class Demo01 {

    // 输入一个字符串，打印出该字符串的所有排列组合。
    public static void main(String[] args) {
        String str = "";
        Scanner scan = new Scanner(System.in);
        str = scan.nextLine();
        permutation(str.toCharArray(), 0);
    }

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
