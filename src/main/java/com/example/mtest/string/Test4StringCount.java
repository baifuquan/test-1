package com.example.mtest.string;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author : baifuquan
 * @date : 2022/7/6 17:12
 * @className : TestStringCount1
 * @description : 统计字符中的字母，空格，数字，和其他字符的个数
 **/
public class Test4StringCount {

    /**
     * 思路：
     * 英文字母a~z，A~Z ，数字0~9，空格为blank，除此之外都是其他字符
     * @param args
     */
    public static void main(String[] args) {

        //数字计数器
        int digital = 0;
        //英文字母计数器
        int character = 0;
        //其他字符计数器
        int other = 0;
        //空格字符计数器
        int blank = 0;

        char[] ch = null;

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        ch = s.toCharArray();
        for(int i=0;i<ch.length;i++) {
            if(ch[i] >= '0' && ch[i] <= '9') {
                digital++;
            }else if((ch[i] >= 'a' && ch[i] <= 'z') || ch[i] >= 'A' && ch[i] <= 'Z') {
                character ++;
            }else if(ch[i] == ' ') {
                blank ++;
            }else{
                other ++;
            }
        }
        System.out.println("英文字母个数： " + character);
        System.out.println("空格字母个数： " + blank);
        System.out.println("数字个数： " + digital);
        System.out.println("其他字母个数： " + other);


    }

    @Test
    public void strCompare() {
        String str1 = "abc";
        String str2 = "abc";
        System.out.println(str1 == str2);
        // true str1 和 str2 在内存中指向同一个对象


        String a = new String("abcd");
        String b = new String("abcd");
        System.out.println(a==b);
        System.out.println(a.equals(b));// true equals比较的是值
        // false a 和 b 在内存中不是指向同一个对象，指向不同的对象


    }

}
