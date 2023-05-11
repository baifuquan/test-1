package com.example.mtest.string;

import java.util.Scanner;

/**
 * @author : baifuquan
 * @date : 2022/7/7 16:24
 * @className : Test10Demo
 * @description : 检查输入的字符串是否是回文字符串
 * 回文字符串：ABCDEEDCBA，对称的字符串
 **/
public class Test10HuiWen {
    public static void main(String[] args) {
        String str;
        Scanner scan = new Scanner(System.in);
        str = scan.nextLine();
        boolean flag = isHui(str);
        if(flag) {
            System.out.println("是回文字符串：" + str);
        } else {
            System.out.println("不是回文字符串：" + str);
        }

        System.out.println("方法二：");
        boolean flag2 = isHui2(str);
        if(flag) {
            System.out.println("是回文字符串：" + str);
        } else {
            System.out.println("不是回文字符串：" + str);
        }

    }

    public static boolean isHui(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (true) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            } else if (i == j && str.charAt(i) == str.charAt(j)) {
                return true;
            } else {
                i++;
                j--;
            }
        }
    }

    public static boolean isHui2(String str) {
        int low = 0;
        int heigh = str.length() -1;
        while (low<heigh) {
            if(str.charAt(low) != str.charAt(heigh)) {
                return false;
            }
            low ++;
            heigh--;
        }
        return true;
    }
}
