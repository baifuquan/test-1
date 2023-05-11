package com.example.mtest.string;

import java.util.Scanner;

/**
 * @author : baifuquan
 * @date : 2022/7/7 15:54
 * @className : Test9Demo
 * @description :
 * 题目：从字符串中删除给定的字符
 *
 * 思路1：通过循环从前往后遍历，如果不是要删除的字符则加到处理后的字符串中
 *
 * 思路2：通过循环确定要删除字符的位置索引，然后通过分割字符串的形式，将子字符串拼接，注意最后的子字符串和原字符串中没有要删除的字符的情况。
 *
 * 思路3：第三种方法原理同上，只不过查找要删除字符的位置采用String类中的函数来执行，效率不如上面高。
 **/
public class Test9DelChar {

    public static void main(String[] args) {
        String str;
        String del;
        Scanner scan = new Scanner(System.in);
        str = scan.nextLine();
        Scanner scanDel = new Scanner(System.in);
        del = scanDel.nextLine();
        System.out.println("方法1：");

        deleteCharString1(str, del.charAt(0));

        System.out.println("方法2：");
        deleteCharString1(str, del.charAt(0));

        System.out.println("方法3：");
        deleteCharString3(str, del.charAt(0));


    }

    /**
     * 思路：通过循环从前往后遍历，如果不是要删除的字符则加到处理后的字符串中
     *
     * @param str        源字符串
     * @param chElemData 删除的字符
     * @return deleteString
     */
    public static String deleteCharString1(String str, char chElemData) {
        String deleteString = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != chElemData) {
                deleteString += str.charAt(i);
            }
        }
        System.out.println(deleteString);
        return deleteString;
    }

    /**
     * 思路：通过循环确定要删除字符的位置索引，然后通过分割字符串的形式，将子字符串拼接，
     * 注意最后的子字符串和原字符串中没有要删除的字符的情况。
     *
     * @param str
     * @param chElemData
     * @return
     */
    public static String deleteCharString2(String str, char chElemData) {
        String deleteString = "";
        int iIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == chElemData) {
                if (i > 0) {
                    deleteString += str.substring(iIndex, i);
                }
                iIndex = i + 1;
            }
        }
        if (iIndex <= str.length()) {
            deleteString += str.substring(iIndex, str.length());
        }
        System.out.println(deleteString);
        return deleteString;
    }

    /**
     * 思路：第三种方法原理同上，只不过查找要删除字符的位置采用String类中的函数来执行，效率不如上面高。
     *
     * @param str
     * @param chElemData
     * @return
     */
    public static String deleteCharString3(String str, char chElemData) {
        String deleteString = "";
        int iIndex = 0;
        int tmpCount = 0;
        do {
            tmpCount = str.indexOf(chElemData, iIndex);
            if (tmpCount > 0) {
                deleteString += str.substring(iIndex, tmpCount);
            }
            if (tmpCount != -1) {
                iIndex = tmpCount + 1;

            }
        } while (tmpCount != -1);

        if (iIndex <= str.length()) {
            deleteString += str.substring(iIndex, str.length());
        }
        System.out.println(deleteString);
        return deleteString;
    }


}
