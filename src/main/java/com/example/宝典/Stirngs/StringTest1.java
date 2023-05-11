package com.example.宝典.Stirngs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringTest1 {
    // 输入一个字符串：打印该字符串的排列组合。

    public static List<String> list = new ArrayList<>();
    /**
     * 思路：可用递归实现。
     * 递归：1.不断缩小问题的规模。2.可用用同一个方法解决下一个问题。3.递归要有边界，注意死循环
     */
    public static void main(String[] args) {
        String str = "";
        Scanner scanner = new Scanner(System.in);
        str = scanner.nextLine();
        char[] chars = str.toCharArray();
        permutation(chars,0);

        System.out.println(list);
    }

    public static void permutation(char[] str, int i) {
        if(i>=str.length) {
            return;
        }
        if(i==str.length - 1) {
            System.out.println(String.valueOf(str));
            list.add(String.valueOf(str));
        }else{
            for(int j=i;j<str.length;j++) {
                char temp = str[j];
                str[j] = str[i];
                str[i] = temp;
                permutation(str,i+1);
                temp = str[j];
                str[j] = str[i];
                str[i] = temp;
            }
        }


    }

}
