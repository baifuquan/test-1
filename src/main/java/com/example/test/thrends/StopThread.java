package com.example.test.thrends;

import javax.annotation.security.RunAs;

/**
 * @author : baifuquan
 * @date : 2022/6/13 09:44
 * @className : StopThread
 * @description : StopThread
 **/
public class StopThread implements Runnable {
    @Override
    public void run() {
        int count = 0;
        while (!Thread.currentThread().isInterrupted() && count < 1000) {
            System.out.println("count = " + count++);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new StopThread());
        thread.start();
        Thread.sleep(5);
        thread.interrupt();
    }
}
