package com.example.test.thrends.volitletest;

import lombok.SneakyThrows;

import java.util.concurrent.BlockingQueue;

/**
 * @author : baifuquan
 * @date : 2022/7/28 17:38
 * @className : Producer
 * @description : Producer
 * 首先，声明了一个生产者 Producer，通过 volatile 标记的初始值为 false 的布尔值 canceled 来停止线程。
 * 而在 run() 方法中，while 的判断语句是 num 是否小于 100000 及 canceled 是否被标记。
 * while 循环体中判断 num 如果是 50 的倍数就放到 storage 仓库中，
 * storage 是生产者与消费者之间进行通信的存储器，
 * 当 num 大于 100000 或被通知停止时，会跳出 while 循环并执行 finally 语句块，告诉大家“生产者结束运行”。
 *
 * 正确做法
 **/
public class Producer implements Runnable {
    public volatile boolean canceled = false;
    BlockingQueue storage;

    public Producer(BlockingQueue storage) {
        this.storage = storage;
    }

    @SneakyThrows
    @Override
    public void run() {

        int num = 0;
        try {
            // volatile canceled 标识终止线程条件是不正确的，
            while (num <= 100000 && !canceled) {
                if (num % 50 == 0) {
                    // 此时可能被阻塞
                    storage.put(num);
                    System.out.println(num + "是50的倍数,被放到仓库中了。");
                }
                num++;
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {

            // 这行并没有打印出来
            System.out.println("生产者结束运行");
        }

    }
}
