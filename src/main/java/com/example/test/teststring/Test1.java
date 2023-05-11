package com.example.test.teststring;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author : baifuquan
 * @date : 2022/6/23 10:33
 * @className : Test1
 * @description : Test1
 **/
public class Test1 {
    public static void main(String[] args) {

    }

    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     * 求无重复字符的最长子串
     * s = "abcabcbb"
     * <p>
     * 滑动窗口：
     * 1.使用两个指针表示字符串中的某个子串（左右边界）左指针表示子串的起始位置，右指针表示子串的结束为止rk
     * 2.在每一步的操作中，我们将左指针向右移动一格，表示我们枚举下一个字符作为起始位置，然后不断向右移动右指针，但是需要保证
     * 两个指针对应的子串没一重复的字符。在移动结束后，这个子串就对应着以左指针开始的，不包含重复字符的最长子串。我们记录下这个子串的长度
     * 3.枚举结束，找到最长子串的长度
     * <p>
     * HashSet 是 Set的一个子接口，不能存放重复的元素。
     * set.contains(str.charAt(right + 1)) 可以也HashMap一样可以用来判断是否有重复字符，
     * 与HashSet相反的是TreeSet，区别是：TreeSet是有序的存放集合结构。
     * <p>
     * //字符串转为数组
     * char[] ch = str.toCharArray(字符串数组，起始位置，长度);
     * // 字符串复制copyValueOf();
     * String str =  String.copyValueOf(ch,start,len);
     * // 字符串截取substring(起始位置,结束位置)
     * String str = str.substring(start,end);
     * //字符串返回字符首次出现的位置和最后一次出现的位置
     * str.indexOf(ch[1]);
     * str.lastIndexOf(ch[1]);
     * //获取字符串的某个字符charAt(索引位置)
     * str.charAt(index);
     */
    @Test
    public void lengthOfLongestSubstring() {
        String str = "pwwkew";
        //定义存放字符串的 HashSet集合
        Set<Character> set = new HashSet<>();
        //起始右指针 置为 -1；
        int right = -1;
        //记录最长的字符串长度；
        int maxLength = 0;
        // i表示左指针依次左移
        for (int i = 0; i < str.length(); i++) {
            if (i != 0) {
                //左指针向右移动一格，存放字符串的 HashSet移除一个字符
                System.out.println("set : " + set);
                set.remove(str.charAt(i - 1));
                System.out.println("set : " + set);
            }
            while (right + 1 < str.length() && !set.contains(str.charAt(right + 1))) {
                // 如果子串集合中不存在这个元素，就添加进去，然后right++继续向右检查
                System.out.println("right: " + right);
                System.out.println("set : " + set);
                set.add(str.charAt(right + 1));
                System.out.println("set : " + set);
                right++;
                System.out.println("right: " + right);
            }
            // 获取的最长的字符串长度
            System.out.println(maxLength);
            maxLength = Math.max(maxLength, right - i + 1);
            System.out.println(maxLength);
        }
        System.out.println(set);
        System.out.println("maxLength = " + maxLength);
    }

    @Test
    public void lengthOfLongestSubstring1() {
        //字符串，无重复子串的最大长度
        String str = "abcabcbb";
        //最大长度
        int maxLength = 0;
        //定义 HashSet 存储最大不重复的子串。
        Set<Character> set = new HashSet<>();
        //定义右指针
        int right = -1;
        //i表示左指针依次左移
        for (int i = 0; i < str.length(); i++) {
            //左指针向右移动一格，存放字符串的 HashSet移除一个字符
            if (i != 0) {
                set.remove(str.charAt(i - 1));
            }
            while (right + 1 < str.length() && !set.contains(str.charAt(right + 1))) {
                //如果子串集合中不存在这个元素，就添加进去，然后right++继续向右检查
                set.add(str.charAt(right + 1));
                right++;
            }
            //获取最长的子字符串长度
            maxLength = Math.max(maxLength, right - i + 1);
        }
        System.out.println(maxLength);
    }

}






