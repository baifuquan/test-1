package com.example.test.mtest2;

import cn.hutool.json.JSONUtil;
import org.junit.Test;

/**
 * @author : baifuquan
 * @date : 2022/5/21 11:25
 * @className : Test1
 * @description : Test1
 **/
public class Test1 {

    public static String[] strArr = {"flower", "","flow", "flight" };
    public static String[] strArr1 = {"abc", "noms", "target" };

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀,如果不存在公共前缀，返回空字符串 ""。
     * 示例 1:
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * 示例 2:
     * 输入：["abc","noms","target"]
     * 输出：""
     * 所有输入只包含小写字母 a-z 。
     * 分析思路：
     * 1.如果字符串数组是null则返回""；
     * 2.如果字符串数组的长度为0则返回""；
     * 3.如果字符串数组中有一个元素为空字符串则返回""；
     * 4.如果字符串数组中只有一个字符串元素，则最长公共前缀就是该元素；
     * 5.第一步先定义一个最终可能返回的字符串变量存储最大公共前缀 str = ""；
     * 第一个循环for循环表示要遍历的轮数（字符串数组的长度-1）
     * 取出第一个字符串数组的元素，假设为最大公共前缀。
     * 下一步 前两个字符串比较，假设为最大公共前缀（第一个字符串）当作第二个字符串的前缀是否成立，
     * 如果成立，则比较第一个和第三个字符串
     * 如果不成立，则第一个字符串从第0为截取len-1当作公共前缀判断是否成立
     * 如果不成立，则继续将第一个字符串从第0到len-2当作公共前缀判断是否是第二个字符串的前缀以此类推直到递减为0；
     * 把字符串数组中第一个元素字符串当作第二个字符串的前缀比较
     */
    @Test
    public void test1() {

//        String str = longestCommonPrefix1(strArr);
        String str = logestCommonPre11(strArr);
        System.out.println(JSONUtil.toJsonStr(str));
    }

    public String longestCommonPrefix1(String[] strs) {

        String ret = "";
        if (strs.length == 0) return ret;
        if (strs.length == 1) return strs[0];

        ret = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(ret)) { //判断与第一个元素的相同字符
                ret = ret.substring(0, ret.length() - 1);
                if (ret.length() == 0) {
                    return "";
                }
            }
        }
        return ret;
    }


    public String longestCommonPre(String[] args) {

        String ret = "";
        //1.判断字符串数组是否为空
        if (args == null || args.length == 0) {
            return ret;
        }
        //2.如果只有一个元素则最大公共前缀就是该元素
        if(args.length == 1) {
            return args[0];
        }

        //3.假设第一个字符串元素是最大公共前缀
        ret = args[0];
        for(int i=1;i<args.length;i++) {
            while (!args[i].startsWith(ret)) {
                ret = ret.substring(0,ret.length()-1);
            }
            if(ret.length()==0) {
                return "";
            }
        }
        return ret;
    }

    public String logestCommonPre11(String[] args) {
        // 1.判断形参字符串数组为null 返回 ""
        // 2.判断形参字符串数组长度为0 返回""；
        // 3.判断形参字符串数组只有一个元素返回该元素本身
        // 4.判断字符串数组只要有一个元素为""则返回""

        if(args == null) {
            return "";
        }
        if(args.length == 0) {
            return "";
        }
        if(args.length == 1) {
            return args[0];
        }

        // 假设第一个元素为最大公共前缀
        String str1 = args[0];
        for(int i=1;i<args.length;i++) {

            while (!args[i].startsWith(str1)) {
                str1 = str1.substring(0,str1.length()-1) ;
            }
            if(str1.length() ==0) {
                return "";
            }
        }
        return str1;
    }
}
