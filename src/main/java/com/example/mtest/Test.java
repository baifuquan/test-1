package com.example.mtest;

import cn.hutool.core.date.CalendarUtil;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;


/**
 * @author : baifuquan
 * @date : 2022/7/5 16:32
 * @className : Test
 * @description : Test
 **/
public class Test {

    public static void main (String[] args) {
        char[] as = {'a','b','c','d','e','f'};
        String a = "1234567890";
        a.getChars(0,6,as,0);
        System.out.println(as);

        String a1 = "a";
        String b1 = "a";
        System.out.println(a1.compareTo(b1));

        SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar = CalendarUtil.beginOfMonth(calendar);
        String str =  smf.format(calendar);
        System.out.println(str);
    }
}
