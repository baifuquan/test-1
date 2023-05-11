package com.example.test.mtest1;

import java.util.Objects;
import org.junit.Test;

public class StringTest1 {
    public static void main(String[] args) {

    }

    @Test
    public void testStarsWith() {
        String str = "hello World";
        if(str.startsWith("helq")) {
            System.out.println("yes");
        }else {
            System.out.println("no");
        }
    }

    @Test
    public void testCompare(){
        String str = "o";
        String str1 = "O";
        if(str.compareTo(str1) == 0) {
            System.out.println("等于");
        }else if(str.compareToIgnoreCase(str1) > 0){
            System.out.println("大于");
        }else{
            System.out.println("小于");
        }
    }

    // java outer:关键字用法
    @Test
    public void test() {
        outer:for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(j==1) {
                    System.out.print(j);
                }else {
                    break outer;   //break;
                }
            }
        }
    }

    // java outer:关键字用法
    @Test
    public void test1() {
        outer:for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println("i = " + i + "  j = " + j);
                if(j==3) {
                    break outer;   //break;
                }
            }
        }
    }

    //String 对象的不可变性
    @Test
    public void testString1() {
        String s1 = "A" + "BC";
        String s2 = "AB" + "C";
        if(s1 == s2) {
            System.out.println("11同一个对象，相等");
        }else {
            System.out.println("11不是同一个对象，不相等");
        }
        String s3 = new String("ABC");
        if(Objects.equals(s1, s3)) {
            System.out.println("22同一个对象，相等");
        }else{
            System.out.println("22不是同一个对象，不相等");
        }
    }
}
