package com.example.mtest.string;

import java.util.Scanner;

/**
 * @author : baifuquan
 * @date : 2022/7/7 11:02
 * @className : Test5CalMaxLength
 * @description : 找出最大的 连续的 子字符串的长度
 * 思路：连续的 字符
 * 首先对整个字符串进行遍历，如果不是连续的字符串，则对前面连续的字符串长度进行判断，
 * 看是不是目前最长的，如果是则保存该字符串长度并且将长度重新计为1
 * 如：输入 "abijkabcd" 则 结果返回 abcd 长度为4 。注意，这里返回的是一个连续的"字符串"而不是数字。
 **/
public class Test5CalMaxLength {

    public static void main(String[] args) {
        String str;
        Scanner scan = new Scanner(System.in);
        str = scan.nextLine();
        System.out.println(str);
        calMaxLength(str);
    }

    public static void calMaxLength(String str) {
        int max = 0;
        //连续字符串计数器
        int temp = 1;
        /**
         * 对整个字符串进行遍历
         */
        for (int i = 1; i < str.length(); i++) {
            char pre = str.charAt(i - 1);
            char now = str.charAt(i);

            //如果是连续字符串，则长度加1
            if (now - pre == 1) {
                temp++;
            } else {
                //如果不是连续字符串，对前面的字符串长度进行判断，看是不是目前最长的，如果是则保存
                //该字符串并且将长度重新计为1
                max = max > temp ? max : temp;
                temp = 1;
            }
        }
        // 因为上面的程序没有对最后一次连续长度进行比较，所以在这里多比较一次
        max = max > temp ? max : temp;
        System.out.println(max == 1 ? 0 : max);
    }

}
