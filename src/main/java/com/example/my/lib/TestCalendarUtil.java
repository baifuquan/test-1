package com.example.my.lib;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestCalendarUtil {

    //获取当月第一个天和最后一天
    public static Map<String,String> getFirstLastOfCurrentMon(){
        HashMap<String,String> hm = new HashMap<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String firstDay,lastDay;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        //获取第一天
        calendar.add(Calendar.MONTH,0);
        calendar.set(Calendar.DAY_OF_MONTH,1);
        firstDay = format.format(calendar.getTime());
        //获取最后一天
        calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH,1);
        calendar.set(Calendar.DAY_OF_MONTH,0);
        lastDay = format.format(calendar.getTime());
        hm.put("first",firstDay);
        hm.put("last",lastDay);
        return hm;
    }

    //获取当月第一个天和最后一天
    public static Map<String,String> getFirstLastOfCurrentMon1(){
        HashMap<String,String> hm = new HashMap<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String firstDay,lastDay;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH,0);
        //获取第一天
        calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        firstDay = format.format(calendar.getTime());
        //获取最后一天
        calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        lastDay = format.format(calendar.getTime());
        hm.put("first",firstDay);
        hm.put("last",lastDay);
        return hm;
    }

    //获取当前年的第一天和最后一天
    public static Map<String,String> getFirstLastOfCurrentYear(){
        HashMap<String,String> hm = new HashMap<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String firstDay,lastDay;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
//        calendar.add(Calendar.YEAR,0);
        //获取第一天
        calendar.set(Calendar.DAY_OF_YEAR,calendar.getActualMinimum(Calendar.DAY_OF_YEAR));
        firstDay = format.format(calendar.getTime());
        //获取最后一天
        calendar.set(Calendar.DAY_OF_YEAR,calendar.getActualMaximum(Calendar.DAY_OF_YEAR));
        lastDay = format.format(calendar.getTime());
        hm.put("first",firstDay);
        hm.put("last",lastDay);
        return hm;
    }

    //获取两个时间段范围内的日期。
    public static List<String> getDate(String startDate,String endDate) {
        List<String> list = new ArrayList<>();
        return list;
    }

    public static void main(String[] args)  {
        //
        Date date = new Date();
        SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat yyyyMM = new SimpleDateFormat("yyyy-MM");

        try {
            date = yyyyMMddHHmmss.parse("2022-01-01 00:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date);
        String str = yyyyMMddHHmmss.format(date);
        String str1 = yyyyMMdd.format(date);
        System.out.println(str);
        System.out.println(str1);
        Map<String,String> hm = getFirstLastOfCurrentYear();
        System.out.println(hm);
    }
}
