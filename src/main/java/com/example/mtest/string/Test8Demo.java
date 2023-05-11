package com.example.mtest.string;

import cn.hutool.json.JSONUtil;

import java.util.Arrays;

/**
 * @author : baifuquan
 * @date : 2022/7/7 15:31
 * @className : Test8Demo
 * @description :
 * 题目：一个字符串中包含*和数字，将*放到开头
 * 解析：字符串中特殊符号的提取，并且将其排列到指定的位置
 * 思路:遍历字符串，倒着操作，从最大下表开始向前遍历，遇到非*的元素则加入"新"下标中，遍历完成后，j代表*的个数，然后将0-j复制为*即可
 * 操作后，数字的相对位置不变
 **/
public class Test8Demo {
    public static void main(String[] args) {
        char[] chars = new char[]{'1', '*', '4', '3', '*', '5', '*'};
        // 操作后数字的相对位置不变
        // 倒着操作：从最大下标开始向前遍历，遇到非*的元素则加入"新"下标中，遍历完毕后
        //  j 代表*的个数，然后将0-j复制为*即可
        int j = chars.length - 1;
        for (int i = j; i >= 0; i--) {
            if (chars[i] != '*') {
                chars[j--] = chars[i];
            }
        }
        while (j >= 0) {
            chars[j--] = '*';
        }
        for (char c : chars) {
            System.out.print(c + ", ");
        }
        System.out.println(Arrays.toString(chars));

    }
}
