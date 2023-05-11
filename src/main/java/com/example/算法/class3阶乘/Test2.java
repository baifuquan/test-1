package com.example.算法.class3阶乘;

/**
 * @author : baifuquan
 * @date : 2022/7/20 15:24
 * @className : Test2
 * @description : Test2
 **/
public class Test2 {
    public static void main(String[] args) {

        long ans = f2(10);

        long ans1 = f3(10);
    }

    /**
     * 求：n的阶乘：
     * 1*1 + 1*2 + 1*2*3 + 1*2*3*4
     * @param n
     * @return
     */
    public static long f1(long n) {
        long ans = 1;
        for (long i = 1; i <= n; i++) {
            ans *= i;
        }
        return ans;
    }

    /**
     * N1+N2+N3+N4
     *
     * @param n
     * @return
     */
    public static long f2(long n) {
        long ans = 1;
        for (long i = 1; i <= n; i++) {
            ans += f1(i);
        }
        System.out.println(ans);
        return ans;
    }


    public static long f3 (long n ) {
        long ans = 1;
        long cur = 1;
        for (long i = 1; i<=n; i++) {
            cur  = cur * i;
            ans += cur;
        }
        System.out.println(ans);
        return ans;
    }

}
