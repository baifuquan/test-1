package com.example.test.thrends.volitletest;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author : baifuquan
 * @date : 2022/7/28 17:48
 * @className : VolatileTest
 * @description : VolatileTest
 **/
public class VolatileTest {

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue storage = new ArrayBlockingQueue(8);

        Producer producer = new Producer(storage);

        Thread producerThread = new Thread(producer);
        producerThread.start();
        producerThread.sleep(500);


        Consumer consumer = new Consumer(storage);
        while (consumer.needMoreNums()) {
            System.out.println(consumer.storage.take() + "被消费了");
            Thread.sleep(100);
        }
        System.out.println("消费者不需要更多数据了。");

        //一旦消费不需要更多数据了，我们应该让生产者也停下来，但是实际情况却停不下来
        // 错误做法终止生产者
        producer.canceled = true;
        //System.out.println(producer.canceled);

        // 正确做法终止生产者
        producerThread.interrupt();
    }
}
