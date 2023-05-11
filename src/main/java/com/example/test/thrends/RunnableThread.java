package com.example.test.thrends;

/**
 * @author : baifuquan
 * @date : 2022/6/9 09:06
 * @className : RunnableThread
 * @description : RunnableThread 实现多线程方法一
 **/
public class RunnableThread implements Runnable{
    // 重写
    @Override
    public void run() {
        System.out.println("实现Runnable接口实现多线程");
    }
}
