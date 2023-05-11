package com.example.mtest.string;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author : baifuquan
 * @date : 2022/7/4 10:39
 * @className : Test2
 * @description : 字符串中第一个唯一字符的位置
 **/
public class Test1UniqChar {
    public static void main(String[] args) {
        System.out.println("hello");
    }

    /**
     * 字符串中第一个唯一字符的位置
     */
    public static Integer firstUniqChar(String str) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char s = str.charAt(i);
            hm.put(s, hm.getOrDefault(s, 0) + 1);
        }
        for (int j = 0; j < str.length(); j++) {
            if (hm.get(str.charAt(j)) == 1) {
                return j;
            }
        }
        return -1;
    }


    @Test
    public void mytest() {
        String str = "aabbccdeffhjj";
        System.out.println(firstUniqChar(str));

        System.out.println(firstUniqChar1(str));
    }

    public static Integer firstUniqChar1(String str) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char s = str.charAt(i);
            hm.put(s, hm.getOrDefault(s, 0) + 1);
        }
        for (int j = 0; j < str.length(); j++) {
            if (hm.get(str.charAt(j)) == 1) {
                return j;
            }
        }
        return -1;

    }

    /**
     * 字符串中第一个唯一字符的位置 第二种方式
     * 时间复杂度：O(n)
     * HashTable求解
     *
     */
    public void findFirst(String str){
        if(str==null) {
            return ;
        }
        int i;
        char[] arr = str.toCharArray();
        int[] hashTable = new int[256];
        for (i=0;i<256;i++){
            hashTable[i] = 0;
        }
        for(i=0; i< arr.length; i++){
            int tmp = arr[i];//将char转换为int，即转化为其对应的ASCII码
            hashTable[tmp]++;
        }
        for(i= 0; i< arr.length; i++){
            if(hashTable[arr[i]] == 1) {
                System.out.println((char) arr[i]);
                return;
            }
        }
    }

    @Test
    public void Test11(){
        findFirst("aabbcddeffz");
    }


}


