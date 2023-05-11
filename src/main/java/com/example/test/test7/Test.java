package com.example.test.test7;

/**
 * @author : baifuquan
 * @date : 2022/6/30 17:16
 * @className : Test
 * @description : Test
 **/
public class Test {

    public static void main(String[] args) {

        String str1 = "ADOBECODEBANC";
        String str2 = "ABC";
    }

    /**
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 ""
     * 注意：
     * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
     * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
     *
     * @param s
     * @param t
     * @return
     */
    public static String retString(String s, String t) {
        //
        String res = "";
        int sLen = s.length();
        int tLen = t.length();
        if (sLen < tLen) {
            return "";
        }
        int i = 0;
        int j = sLen;

            return res;
    }
}
