package com.example.mtest.string;

import java.util.Scanner;

/**
 * @author : baifuquan
 * @date : 2022/7/7 10:19
 * @className : Test3ChangeOrder
 * @description : 反转句子
 * 如：输入 I am a student 输出 student a am I
 * 思路：
 * 1.将整个字符串倒置
 * 2.以空格为界，倒置字符
 * 字符串的反转主要通过字符的交换来实现，需要首先吧自妇产转换为字符数组，然后定义两个索引分别指向数组的首位，再交换两个索引位置的值。
 * 同时，吧两个索引的值的指向中间移动，知道两个索引相遇为止。
 **/
public class Test3ChangeOrder {

    public static void main(String[] args) {
        String str;
        Scanner scan = new Scanner(System.in);
        str = scan.nextLine();
        changeOrder(str);

    }

    public static void changeOrder(String str) {
        char[] ch = str.toCharArray();
        char temp;
        int begin;
        int end;

        int i = 0;
        int srcLen = ch.length;
        //转换这个字符串
        swap(ch, i, srcLen - 1);
        //以空为单位，转换空格前后的字符串顺序，使单词为正常
        for (int j = 0; j < srcLen; j++) {
            if (ch[j] != ' ') {
                begin = j;
                //为保证不越界
                while (ch[j] != ' ' && (j + 1) < srcLen) {
                    j++;
                }
                if (j == srcLen - 1) {
                    end = srcLen - 1;
                } else {
                    end = j - 1;
                }
                swap(ch, begin, end);
            }
        }
        String string = String.copyValueOf(ch);
        System.out.println(string);
    }

    // 交换字符
    public static void swap(char[] arr, int begin, int end) {
        char temp;
        while (end > begin) {
            temp = arr[begin];
            arr[begin] = arr[end];
            arr[end] = temp;
            end--;
            begin++;
        }
    }
}
