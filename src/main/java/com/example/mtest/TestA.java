package com.example.mtest;

/**
 * @author : baifuquan
 * @date : 2022/7/6 11:26
 * @className : TestA
 * @description : TestA
 **/
public class TestA {

    String AA = "hello";
    TestA() {

    }

    public void say() {
        System.out.println("TestA say function");
    }
}

abstract class TestB extends TestA {
    TestB(){
        System.out.println(" TestB(){");
    }
    public Integer age;
    public void say() {

    }

    public static void main(String[] args) {
        System.out.println("aaa");
        TestB a = new TestB() {
            @Override
            public void say() {
                System.out.println("Testb say function");

                super.say();
            }
        };

        System.out.println(a);
    }

}
