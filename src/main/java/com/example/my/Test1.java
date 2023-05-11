package com.example.my;

import com.example.my.lib.TestCalendarUtil;

import java.util.Map;

public class Test1 {
    public static void main(String[] args) {
        Map<String,String> map = TestCalendarUtil.getFirstLastOfCurrentMon();
        TestCalendarUtil calendarUtil = new TestCalendarUtil();
        Map<String,String> map1 = calendarUtil.getFirstLastOfCurrentMon();
        System.out.println(map);
        System.out.println(map1);
    }

}
