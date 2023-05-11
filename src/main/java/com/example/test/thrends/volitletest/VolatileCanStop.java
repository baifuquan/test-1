package com.example.test.thrends.volitletest;

/**
 * @author : baifuquan
 * @date : 2022/7/28 17:29
 * @className : VolatileCanStop
 * @description : VolatileCanStop
 *
 * volatile 修饰标记位适用的场景
 **/
public class VolatileCanStop implements Runnable {
    private volatile boolean canceled = false;

    @Override
    public void run() {
        int num = 0;

        try {
            while (!canceled && num <= 100000000) {
                if (num % 10 == 0) {
                    System.out.println(num + "是10的倍数。");
                }
                num++;
                Thread.sleep(1);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        VolatileCanStop r = new VolatileCanStop();
        Thread thread = new Thread(r);
        thread.start();
        Thread.sleep(3000);
        r.canceled = true;

    }
}
