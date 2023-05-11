package com.example.mtest.string;

import java.util.HashMap;

/**
 * @author : baifuquan
 * @date : 2022/6/20 15:47
 * @className : Demo02
 * @description : 在字符串中找出第一个只出现一次的字符,返回下表
 **/
public class Test11FindFirstChar {

    public static void main(String[] args) {

        String str = "aabbcdezzddrefdss";
        int res = findFirst1(str);
        System.out.println(res);
    }

    public static int findFirst1(String str) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            Character key = str.charAt(i);
            Integer value = hm.get(key);
            if (value == null) {
                hm.put(key, 1);
            } else {
                value++;
                hm.put(key, value);
            }
        }
        System.out.println(hm);
        for (int i = 0; i < len; i++) {
            char key = str.charAt(i);
            if (hm.get(key) == 1) {
                System.out.println(i + " : " + str.charAt(i));
                return i;
            }
        }
        return -1;
    }

    /**
     * 在字符串中找出第一个只出现一次的字符
     * HashTable 求解，时间复杂度：O（n）
     *
     * @param str
     */
    public static void findFirst(String str) {
        if (str == null) {
            return;
        }
        int i = 0;
        char[] arr = str.toCharArray();
        int[] HashTable = new int[256];
        for (i = 0; i < 256; i++) {
            HashTable[i] = 0;
        }
        char[] hashKey = arr;
        for (i = 0; i < hashKey.length; i++) {
            int tmp = hashKey[i];// char转为int，即转换为其对应的ASCII码
            HashTable[tmp]++;
        }
        for (i = 0; i < hashKey.length; i++) {
            System.out.println((char) hashKey[i]);
            return;
        }

    }
}
