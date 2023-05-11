package com.example.mtest.string;

/**
 * @author : baifuquan
 * @date : 2022/7/6 16:52
 * @className : Test
 * @description : Test
 **/
public class Test {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, CloneNotSupportedException {
//        String str = "abcdefghijklmnopqrstuvwxyz";
//        System.out.println(str.indexOf("bcd"));


        String str1 = "abc";
        String str2 = "bcd";

        Test t = new Test();

        Test t2 = t.getClass().newInstance();
        Test t3 = (Test) t2.clone();
        System.out.println(t2);
        System.out.println(t3);
        System.out.println(str2.getClass().hashCode());

    }

    public void strStart(){

        StringBuffer sb = new StringBuffer();

        StringBuilder sbu = new StringBuilder();
    }
}
