package com.example.算法.class7java随机函数;

import org.junit.Test;

/**
 * @author : baifuquan
 * @date : 2022/7/15 15:29
 * @className : Test
 * @description : Test
 **/
public class Test01 {

    @Test
    public void test111() {
        double index = 5.99;
        int intIndex = (int) index;
        System.out.println(intIndex);

        int t1 = 19000;
        //short t3 = (short) t1;
        byte t4 = (byte) t1;
        //System.out.println(t3);
        System.out.println(t4);

    }

    // lib黑盒子函数不可改
    /**
     * f1 1到5的随机数，等概率返回
     * 不可修改
     *
     * @return
     */
    public static int f1() {
        return (int) (Math.random() * 5) + 1;
    }

    /**
     * 随机机制只能用f1，等概率返回0和1，
     */
    public static int f2() {
        int ans;
        do {
            ans = f1();
        } while (ans == 3);
        return ans < 3 ? 0 : 1;
    }

    /**
     * 得到000 ~ 111 做到等概率 0 ~ 7等概率返回一个。
     */
    public static int f3() {
        return (f2() << 2) + (f2() << 1) + (f2() << 0);
    }

    /**
     * 得到0到6的等概率的随机数 返回一个。
     *
     * @return k
     */
    public static int f4() {
        int ans = 0;
        do {
            ans = f3();
        } while (ans == 7);
        return ans;
    }

    /**
     * 得到1-7的等概率的函数
     *
     * @return
     */
    public static int g() {
        return f4() + 1;
    }

    public static void main(String[] args) {

        System.out.println(  ((double)15000000/(double)72000));
        System.out.println("dd");

        int testTimes = 100000;
        int count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (f2() == 0) {
                count++;
            }
        }
        //打印f2函数 出现0的概率
        System.out.println((double) count / (double) testTimes);
        System.out.println(count);
        System.out.println("==================");

        int[] counts = new int[8];
        int num;
        for (int i = 0; i < testTimes; i++) {
            num = g();
            counts[num]++;
        }
        for (int i = 0; i < 8; i++) {
            System.out.println(i + "这个数，出现了 " + counts[i] + " 次");
        }



    }
}
