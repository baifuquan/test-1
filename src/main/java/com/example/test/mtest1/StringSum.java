package com.example.test.mtest1;

/**
 * @author : baifuquan
 * @date : 2022/6/16 17:10
 * @className : StringSum
 * @description : 写两个任意长度的纯数字字符串,计算他们相加的值
 * 十进制进位。字符串反转
 **/
public class StringSum {

    public static void main(String[] args) {
        String num1 = "345";
        String num2 = "4567";
        String res = addStrings(num1, num2);
        System.out.println("结果");
        System.out.println(res);
        Long num11 = Long.valueOf(num1);
        Long num22 = Long.valueOf(num2);
        System.out.println(num11 + num22);
    }

    public static String addStrings(String num1, String num2) {
        System.out.println(num1);
        System.out.println(num2);
        StringBuilder res = new StringBuilder("");
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int tmp = n1 + n2 + carry;
            carry = tmp / 10;
            res.append(tmp % 10);
            i--;
            j--;
        }
        if (carry == 1) res.append(1);
        return res.reverse().toString();
    }

    public static String addStrings1(String str1, String str2) {
        StringBuilder res = new StringBuilder();
        int i = str1.length() - 1;
        int j = str2.length() - 1;
        int carry = 0; // 进位
        while (i >= 0 || j >= 0) {
            int a = i >= 0 ? str1.charAt(i) - '0' : 0;
            int b = j >= 0 ? str2.charAt(j) - '0' : 0;
            int temp = a + b + carry;
            carry = temp / 10;
            res.append(temp % 10);
            System.out.println(res);
            i--;
            j--;
        }
        System.out.println(res);
        if (carry == 1) res.append(1);
        return res.reverse().toString();
    }
}
