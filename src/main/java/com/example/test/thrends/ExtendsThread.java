package com.example.test.thrends;

/**
 * @author : baifuquan
 * @date : 2022/6/9 09:08
 * @className : ExtendsThread
 * @description : ExtendsThread 继承Thread类实现多线程
 **/
public class ExtendsThread extends Thread{

    @Override
    public void run() {
        System.out.println("继承Thread类实现多线程");
    }
}
