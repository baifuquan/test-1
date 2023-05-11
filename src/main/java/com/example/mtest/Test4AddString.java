package com.example.mtest;

import java.security.SecureRandom;

/**
 * @author : baifuquan
 * @date : 2022/7/4 11:35
 * @className : Test3AddString
 * @description : 写两个任意长度的纯数字字符串,计算他们相加的值
 * 十进制进位。字符串反转
 **/
public class Test4AddString {

    public static void main(String[] args) {


        String str1 = "8569";
        String str2 = "5678";
        System.out.println(str1.charAt(1));

//        String res = addString(str1, str2);
//        System.out.println(res);
//        System.out.println("d");
    }

    public static String addString(String str1, String str2) {
        // 1.最后一位相加
        // 2.进位
        int i = str1.length() - 1;
        int j = str2.length() - 1;
        int carry = 0; // 进位
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >= 0) {
            // 位数不够，补零
            int n1 = i >= 0 ? str1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? str2.charAt(j) - '0' : 0;
            int temp = n1 + n2 + carry;
            carry = temp / 10;
            System.out.println("carry: " + carry);
            res.append(temp % 10);
            System.out.println("res: " + res);
            i--;
            j--;
        }

        // ???
        if (carry == 1) {
            System.out.println("if carry = 1");
            res.append(1);
            System.out.println(res);
        }
        return res.reverse().toString();
    }

    public static String addString1(String str1, String str2) {
        StringBuilder res = new StringBuilder();
        int i = str1.length() - 1;
        int j = str2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            // 位数不够补零
            int n1 = i >= 0 ? str1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? str2.charAt(j) - '0' : 0;
            int tmp = n1 + n2 + carry;
            carry = tmp / 10;
            res.append(tmp % 10);
            i--;
            j--;
        }
        if(carry == 1) {
            res.append(1);
        }
        return res.reverse().toString();
    }
}
