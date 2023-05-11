package com.example.算法.class3阶乘;

import java.util.Date;

/**
 * @author : baifuquan
 * @date : 2022/7/8 15:01
 * @className : Test1
 * @description : Test1
 * 给一个参数N，返回 1!+2!+3!+4!+5!+...+N! 求 1的阶乘+....+N的阶乘
 * 1! = 1*1
 * 2! = 1*2
 * 3! = 1*2*3
 * 4! = 1*2*3*4
 * 5! = 1*2*3*4*5
 **/
public class Test1 {
    public static long f1(long N) {
        long ans = 0;
        for(int i=1;i<=N;i++) {
            ans += factorial(i);
        }
        return ans;
    }
    public static long factorial(long N) {
        long ans = 1;
        for(int i = 1;i<=N;i++) {
            ans *=i;
        }
        return ans;
    }

    /**
     * @param N
     * @return
     */
    public static long f2(long N) {
        // 记录前一个数的阶乘
        long ans = 0;
        long cur = 1;
        for (int i = 1; i <= N; i++) {
            cur *= i;
            ans +=cur;
        }
        return ans;
    }
    public static void main(String[] args) {
        long N = 5;
        //1005876315485501977
        //1005876315485501977
        System.out.println(System.currentTimeMillis());
        Date start = new Date();
        System.out.println(f2(N));
        Date end = new Date();
        System.out.println(System.currentTimeMillis());
//        System.out.println(f1(N));
    }
}
