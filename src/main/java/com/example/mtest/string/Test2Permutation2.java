package com.example.mtest.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 题目：输入一个字符串，打印出这个字符串的所有排列。
 * 思路：递归。
 * 递归思路：
 * 1.逐渐缩小问题的规模，并且用相同的方法解决子问题。
 * 2.递归要有结束条件，否则会进入死循环
 */
//
//思路：递归实现。思路：

public class Test2Permutation2 {

    public static int cnt = 0;
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String str = "";
        Scanner scanner = new Scanner(System.in);
        str = scanner.nextLine();
        char[] strArr = str.toCharArray();
        permutation(list,strArr,0);
        System.out.println(cnt);
        System.out.println(list.toArray().length);
    }

    /**
     * 思路：字符数组，替换元素，替换完毕就打印
     * @param strArr
     * @param i
     */
    public static  void permutation(List<String> list,char[] strArr,int i){
        //边界
        if(i >= strArr.length) {
            return ;
        }
        //边界
        if(i == strArr.length - 1) {
            System.out.println(String.valueOf(strArr));
            list.add(String.valueOf(strArr));
        }
        for(int j=i;j<strArr.length;j++) {
            char temp = strArr[j];
            strArr[j] = strArr[i];
            strArr[i] = temp;
            cnt++;
            permutation(list,strArr,i+1);
            temp = strArr[j];
            strArr[j] = strArr[i];
            strArr[i] = temp;

        }
    }

}
