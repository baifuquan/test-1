package com.example.mtest;

import cn.hutool.json.JSONUtil;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : baifuquan
 * @date : 2022/7/4 11:08
 * @className : Test3StringCount
 * @description : 给定一个字符串，返回该字符串每个字符出现的次数
 **/
public class Test3StringCount {

    public static void main(String[] args) {
        String str = "aabbbcccc";
        Map<Character, Integer> res = StringCount1(str);
        System.out.println(JSONUtil.toJsonStr(res));
    }

    /**
     * 统计每个字符串出现的次数
     *
     * @param str
     * @return
     */
    public static Map<Character, Integer> StringCount1(String str) {
        HashMap<Character, Integer> hm = new HashMap<>();

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

        System.out.println(JSONUtil.toJsonStr(hm));
        return hm;
    }
}
