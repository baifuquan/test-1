package com.example.算法.class1位运算;

import org.junit.Test;

/**
 * @author : baifuquan
 * @date : 2022/7/8 09:49
 * @className : Code01PrintB
 * @description : 打印二进制
 * 正数（int）打印32位状态
 **/
public class Code01PrintB {

    /**
     * @param num
     * @description 正数（int）打印32位状态
     * 左移都是无符号的，右移是有符号的
     */
    public static void print(int num) {
        for (int i = 31; i >= 0; i--) {
//            System.out.println("i: " + i + " " + (1 << i));
//            System.out.println(num & (1 << i));
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 32位，底层都是32位
        int num = 22;
        print(num);

        int a = -0;
        int b = ~a+1;
        System.out.println(a);
        System.out.println(b);
        print(a);
        print(b);
    }

    // 反码和补码

    /**
     * 计算机里 int  32位 最大可以表示 2^32-1 = 42亿多
     * 在java中，int最大存储21亿多如下
     */
    @Test
    public void javaInt() {
        //2147483647
//        System.out.println(Integer.MAX_VALUE);
//        print(Integer.MAX_VALUE);
        //21亿多 2147483647 计算机里表示最大正数是 2^32-1  01111111111111111111111111111111
        //最高位是0 没占用，有特殊含义 ，后面的才是表示真实的


        // 如果是无符号正数，最大的存储范围就是42亿多，比如c++，存储 0 - 2^32-1

        //计算机里正负数的表示
        //正数：最高位是0 则是非负数，一定是正数
        //负数：最高位是1 后面的二进制数取反+1
//        print(-1); // 11111111111111111111111111111111
        //第一位1 是负号 剩下的取反变成好多个00000 然后+1 就是了，取反是有含义的。。。。

//        System.out.println(Integer.MIN_VALUE); //-2147483648
//        print(Integer.MIN_VALUE); // 10000000000000000000000000000000

//        //  取反：
//        int aa = 232131;
//        int bb = ~aa; // 取反负号 ~
//        System.out.println(aa); // 232131
//        System.out.println(bb); // -232132
//        print(aa); // 00000000000000111000101011000011
//        System.out.println("");
//        print(bb); // 11111111111111000111010100111100


//        print(-5);
//        print(Integer.MAX_VALUE);// 11111111111111111111111111111011
//        print(Integer.MIN_VALUE);// 01111111111111111111111111111111

        //系统里
        // + 是 十进制么？
        // - 是 十进制么？
        // * 是 十进制么？
        // / 是 十进制么？
        // % 是 十进制么？
        // 这些符号都要翻译成二进制来算，每一个翻译背后都是二进制的

        // 通过位运算来实现 加减乘除的
        // 位，与，或，反
        // & 与
        // ^
        // l 或
        // ~ 取反

        // 正负数取反逻辑设计，是为了运算效率更快，可以使用同一套逻辑，原理再继续展开，就设计单片机领域的知识了

//        int a = 23133;
//        int b = 32424;
//        print(a);
//        print(b);
//        System.out.println("============");
////        print(a ^ b);
////        print(a | b);
//        print(a & b);

        // 右移
//        int a = 1024;
//        print(a);      //00000000000000000000010000000000
//        //右移 1 位，右边补位，符号位来补位
//        print(a >> 1); //00000000000000000000001000000000

        // 系统最小，带负号右移 >>
//        int b = Integer.MIN_VALUE;
//        print(b);      // 10000000000000000000000000000000
//        print(b >> 1); // 11000000000000000000000000000000
//        // 系统最小，不带符号右移  >>>
//        print(b >>> 1); // 01000000000000000000000000000000

        // 总结：N取反+1 就等于 N的相反数

        //加减乘除走一套逻辑怎么理解？
        // a取相反数，就是 取反+1 即 ： ~5+1 。取反 不管-5 还是5 ，可以走一套逻辑了
//        print(5);  //00000000000000000000000000000101
//        print(-5); //11111111111111111111111111111011
        // 负数：补码+1

        //系统最小 的 相反数 都是取反加一
        // 系统最小的负数等于取反加一 还是他本身,比如下，不管是c++ 还是别的语言系统，都是这样
//        int min = Integer.MIN_VALUE;
//        print(min);
//        print(-min);
//        print(~min+1);

//        int max = Integer.MAX_VALUE;
//        print(max);
//        print(-max);
//        print(~max+1);

        System.out.println(Integer.MIN_VALUE);
        System.out.println(-Integer.MIN_VALUE);

    }

    @Test
    public void printBinary() {
        int a = 123;
        int b = 456;
        print(a);
        print(b);
        System.out.println("或：一个为1则为1否则为0");
        print(a | b);
        System.out.println(a | b);

        System.out.println("与：相同为1不同为0");
        print(a & b);
        System.out.println(a & b);

        System.out.println("异或：相同为0不同为1");
        print(a ^ b);
        System.out.println(a ^ b);

    }

    // 右移动是用符号为来补,系统最小值用0来补，系统最小值右移一位，都是最大值
    @Test
    public void yi() {
//        int a= -1;
//        print(a);
//        System.out.println(a);
//        print(a >> 1);
//        System.out.println(a >> 1);
//        print(a >>> 1);
//        System.out.println(a >>> 1);

        System.out.println("===============");
        int a= Integer.MIN_VALUE;
        print(a);
        System.out.println(a);
        print(a >> 1);
        System.out.println(a >> 1);
        print(a >>> 1);
        System.out.println(a >>> 1);

    }
}
