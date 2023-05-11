package com.example.test.thrends;

/**
 * @author : baifuquan
 * @date : 2022/6/14 14:35
 * @className : ThreadSafeTest
 * @description : ThreadSafeTest
 **/
public class ThreadSafeTest {

    static volatile int i;

    public static void main(String args[]) throws InterruptedException {

        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 10000; j++) {
                    i++;
                    System.out.println("i: " + i);
                }
            }
        };

        Thread t1 = new Thread(r);
        t1.start();
//        Thread t2 = new Thread(r);
//        t2.start();
//
//        t1.join();
//        t2.join();
//        System.out.println(i);
    }

}
