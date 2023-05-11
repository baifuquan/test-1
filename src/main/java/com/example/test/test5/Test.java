package com.example.test.test5;


import java.util.HashMap;

/**
 * @author : baifuquan
 * @date : 2022/6/17 14:02
 * @className : Tes
 * @description : Tes
 **/
public class Test {
    public static void main(String[] args) {
        String orgId = "JM002";
        String end = orgId.substring(orgId.length()-2);
        System.out.println(end);
        System.out.println(end);


//        String str = "1113334";
//        HashMap<Character, Integer> res = stringCount(str);
//        System.out.println(JSONUtil.toJsonStr(res));
        String str1 = "4566565";
        String str2 = "456765363";
        System.out.println( 4566565 + 456765363);
        String res = strSum(str1, str2);
        System.out.println(res);
    }

    // 两个数字字符串长度任意的，不限制 求和
    public static String strSum(String str1, String str2) {
        //1.从最后一位开始相加
        //2.进位
        StringBuilder res = new StringBuilder();
        int i = str1.length() - 1;
        int j = str2.length() - 1;
        int carray = 0; // 进位
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? str1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? str2.charAt(j) - '0' : 0;
            int temp = n1 + n2 + carray;
            carray = temp / 10;
            res.append(temp % 10);
            i--;
            j--;
        }
        return res.reverse().toString();
    }

    public static HashMap<Character, Integer> stringCount(String str) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            Character key = str.charAt(i);
            if (hm.get(key) == null) {
                hm.put(key, 1);
            } else {
                int value = hm.get(key);
                value++;
                hm.put(key, value);
            }
        }
        return hm;
    }
}
