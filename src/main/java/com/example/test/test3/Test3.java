package com.example.test.test3;

import cn.hutool.json.JSONUtil;
import org.junit.Test;

/**
 * @author : baifuquan
 * @date : 2022/5/21 10:27
 * @className : Test3
 * @description : Test3
 **/
public class Test3 {

    private static int a = 0;
    /**
     * 请问最后a 输出多少？
     * A.大于或等于200
     * B.小于或等于200
     * C.大于或等于100
     * D.小于或等于100
     * E.总是大于100
     * F.总是大于200
     * G.总是等于100
     * H.总是等于200
     *
     * 答案：B
     * 原因：
     * 线程不安全，两个线程可能同时拿到a，两个工作内存a在某一时刻可能存在相同，
     * 之后向主内存刷数的时候存在覆盖。
     * 可能会出现 t1 执行过程中中断了此时a为 50，t2一直正常执行完，则输出 50 + 100 = 150
     *
     */
    @Test
    public void test1() {
        System.out.println("aa");
        Runnable r = () -> {
            for (int j = 0; j < 100; j++) {
                a += 1;
            }
        };
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        try{
            // join 线程死掉的时候 执行该方法。该方法会抛出 清除 线程中断状态 的异常
            t1.join();
            t2.join();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a);
        System.out.println(JSONUtil.toJsonStr(a));
    }

}
