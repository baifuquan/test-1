package com.example.test.test4;

import org.junit.Test;

/**
 * @author : baifuquan
 * @date : 2022/6/20 10:30
 * @className : Test
 * @description : Test
 **/
public class StringTest {
    public static void main(java.lang.String[] args) {
        System.out.println("hh");
    }

    @Test
    public void strCom() {
        // TODO document why this method is empty

        String str = "HELLO";
        System.out.println(str.compareTo("HELLO"));
        System.out.println(str.compareToIgnoreCase("HELLO"));

        System.out.println(122%3);
    }
}
