package com.example.test.thrends.study;

import org.junit.Test;

public class StudyThread {

    public static void main(String[] args) {
    }

    @Test
    public void test1() {
        Thread thread = new Thread();

        thread.getId();
        thread.getName();
        thread.getThreadGroup();
        thread.getPriority();
        thread.getStackTrace();
        thread.getState();
        thread.getContextClassLoader();
        thread.getUncaughtExceptionHandler();
        System.out.println(thread.getId());
        System.out.println(thread.getName());
        System.out.println(thread.getThreadGroup());
        System.out.println(thread.getPriority());
        System.out.println(thread.getStackTrace());
        System.out.println(thread.getState());
        System.out.println(thread.getContextClassLoader());
        System.out.println(thread.getUncaughtExceptionHandler());

        System.out.println();

        System.out.println();

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();



    }
}
