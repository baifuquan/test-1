package com.example.test.thrends;

/**
 * @author : baifuquan
 * @date : 2022/7/28 17:17
 * @className : StopDuringSleep
 * @description : StopDuringSleep
 *
 * Thread.sleep()
 * sleep 期间能否感受到中断？可以感受到并抛出异常java.lang.InterruptedException: sleep interrupted
 **/
public class StopDuringSleep {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            int num = 0;
            try {
                while (!Thread.currentThread().isInterrupted() && num <= 1000) {
                    System.out.println(num);
                    num++;
                    //每休息1000秒 打印一次
                    Thread.sleep(1000000);
                }
            } catch (InterruptedException e) {
                // 在这里不处理该异常是非常不好的
                e.printStackTrace();
//                Thread.currentThread().interrupt();

            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        // 主线程休息5毫秒
        Thread.sleep(5);
        thread.interrupt();
    }
}
