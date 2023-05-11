package com.example.test.thrends.volitletest;

import java.util.concurrent.BlockingQueue;

/**
 * @author : baifuquan
 * @date : 2022/7/28 17:44
 * @className : Consumer
 * @description : Consumer
 *
 * 而对于消费者 Consumer，它与生产者共用同一个仓库 storage，
 * 并且在方法内通过 needMoreNums() 方法判断是否需要继续使用更多的数字，
 * 刚才生产者生产了一些 50 的倍数供消费者使用，消费者是否继续使用数字的判断条件是产生一个随机数并与 0.97 进行比较，
 * 大于 0.97 就不再继续使用数字。
 **/
public class Consumer {
    BlockingQueue storage;
    public Consumer(BlockingQueue storage) {
        this.storage = storage;
    }

    public boolean needMoreNums(){
        if(Math.random() > 0.97) {
            return false;
        }
        return true;
    }
}
