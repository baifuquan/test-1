package com.example.算法.class8不等概率的到等概率;

/**
 * @author : baifuquan
 * @date : 2022/7/20 17:01
 * @className : Test
 * @description :
 * <p>
 * fn()函数不等概率返回函数f(0,1) ,的到 g(0,1)等概率函数
 **/
public class Test {

    /**
     * fn()函数不等概率返回函数f(0,1)
     *
     * @return int 0,1
     */
    public static int fn() {
        return Math.random() < 0.82 ? 0 : 1;
    }

    /**
     * 目标函数 等概率返回 0 ，1
     * 思路：
     * 两次fn函数 分别返回 0 ，1 的概率为
     * 0 0
     * 1 1
     * 0 1
     * 1 0
     *
     * p = 1-p :去掉两次fn调用出现相同的概率，则就剩下概率相同的概率了
     *
     * @return
     */
    public static int g() {
        int cur = 0;
        do {
            cur = fn();
        }while (cur == fn());
        return cur;
    }
    public static void main(String[] args) {
        int testTimes = 100000;
        int count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (g() == 1) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);
    }


}
