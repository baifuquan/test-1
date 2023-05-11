package com.example.test.mtest1;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * @author : baifuquan
 * @date : 2022/6/16 15:34
 * @className : StringCount
 * @description : StringCount
 **/
public class StringCount {

    public static void main(String[] args) {
        //键盘录入一个字符
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String line = sc.nextLine();

        //创建HashMap集合,键是Character，值是Integer。
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        //如果想让字符按顺序排序，把HashMap改成TreeMap

        //遍历字符串，得到每个字符。
        for (int i = 0; i < line.length(); i++) {
            char key = line.charAt(i);
            //拿得到的每一个字符作为键到HashMap集合中去找对应的值
            Integer value = hm.get(key);
            if (value == null) {
                //如果返回值是null：说明该字符在HashMap集合中不存在，就把该字符作为键，1作为值存储；
                hm.put(key, 1);
            } else {
                //如果返回值不是null：说明该字符在HashMap集合中存在，把该值加1，然后重新存储该字符和对应的值。
                value++;
                hm.put(key, value);
            }
        }

        //遍历HashMap集合，得到键和值，按照要求进行拼接。
        StringBuilder sb = new StringBuilder();//拼接需要
        Set<Character> keySet = hm.keySet();
        for (Character key : keySet) {
            Integer value = hm.get(key);
            //拼接
            sb = sb.append(key).append("(").append(value).append(")");
        }

        //StringBuilder转换程string类型
        String s = sb.toString();
        System.out.println(s);
    }
}

