package com.example.mtest.string;



/**
 * @author : baifuquan
 * @date : 2022/7/7 11:36
 * @className : Test7Demo
 * @description :
 * 题目：删除字符串中所有的a ，并且复制所有的b
 * 解析:查找和删除指定的字母，并且复制指定的字母
 * 思路：删除字符串中的a，并且吧字符串中的b全部复制
 **/
public class Test7Demo {

    public static void main(String[] args) {
        char[] input = new char[]{'a', 'b', 'c', 'd', 'a', 'f', 'a', 'b', 'c', 'd', 'b', 'b', 'a', 'b'};

        char[] chars = new char[50];
        for (int j = 0; j < input.length; j++) {
            chars[j] = input[j];

        }
        System.out.println("操作前：");
        for (char c : chars) {
            System.out.print(c + ", ");
        }

        int n = 0;
        int countB = 0;
        //删除a,用n当做新下标，循环遍历数组，不是a的元素都放到新下标的位置
        //由于新n增长慢，下标i增长快，所以元素不会有覆盖
        //由于在删除a是顺便几下b的数量，以便于下一步复制b是可以提前确定数组最终的最大的下标
        for (int i = 0; chars[i] != '\u0000' && i < chars.length; i++) {
            if (chars[i] != 'a') {
                chars[n++] = chars[i];
            }
            if (chars[i] == 'b') {
                countB++;
            }
        }

        //复制b，由于在第一步中就已经知道了字符串中b的个数，这里就能确定最终字符串的最大小表，
        int newMaxIndex = n + countB - 1;
        for (int k = n - 1; k >= 0; k--) {
            chars[newMaxIndex--] = chars[k];
            if (chars[k] == 'b') {
                chars[newMaxIndex--] = chars[k];
            }
        }
        System.out.println("");
        System.out.println("操作后：");
        for (char c : chars) {
            System.out.print(c + ", ");
        }


    }
}
