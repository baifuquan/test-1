package com.example.test.mtest1;

import cn.hutool.json.JSONUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author : baifuquan
 * @date : 2022/6/16 15:14
 * @className : StringSearchCount
 * @description : 写一个字符串,计算每个字符的出现的次数
 **/
public class StringSearchCount {

    public static final String STR = "aabbbcddefffzfdcchh";

    public static void main(String[] args) {
        Map<Character, Integer> resHm = stringCount2(STR);
        System.out.println(JSONUtil.toJsonStr(resHm));
    }

    public static Map<Character, Integer> stringCount(String str) {
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for (int i = 0; i < str.length(); i++) {
            char key = str.charAt(i);
            Integer value = hm.get(key);
            if (value == null) {
                hm.put(key, 1);
            } else {
                value++;
                hm.put(key, value);
            }
        }
        System.out.println(hm);
        return hm;
    }


    public static Map<Character,Integer> stringCount2(String str) {
        HashMap<Character,Integer> hm = new HashMap<>();
        int len = str.length();
        for(int i=0;i<len;i++) {
          Character key = str.charAt(i);
          Integer value = hm.get(key);
          if(value == null)  {
              hm.put(key,1);
          }else {
              value ++;
              hm.put(key,value);
          }
        }
        return hm;
    }
}
