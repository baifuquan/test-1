package com.example.test.thrends;

import java.util.concurrent.ThreadFactory;

/**
 * @author : baifuquan
 * @date : 2022/6/9 09:11
 * @className : DefaultThreadFactory
 * @description : DefaultThreadFactory
 * 第 3 种方式：通过线程池创建线程。线程池确实实现了多线程，比如我们给线程池的线程数量设置成 10，
 * 那么就会有 10 个子线程来为我们工作，接下来，我们深入解析线程池中的源码，来看看线程池是怎么实现线程的？
 **/
public class DefaultThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {

        return null;
    }


}
