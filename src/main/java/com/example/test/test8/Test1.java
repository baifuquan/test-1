package com.example.test.test8;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
import org.junit.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;

/**
 * @author : baifuquan
 * @date : 2022/10/27 22:34
 * @className : Test
 * @description : Test
 **/
public class Test1 {


    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(1L);
        System.out.println(81.51+86.31+82.31+84.71+83.93+91.91+94.31+85.54+94.00);
        System.out.println(79.84+81.51+86.31+82.31+84.71+83.93+91.91+94.31+85.54);


        List<String> dates = new ArrayList<>();
        dates.add("20190101");
        dates.add("20190101");
        dates.add("20190101");
        System.out.println("hello");
    }




    // 日，月，季度，年，半年，周，旬
    //1.改造方法，把时间范围传参下渗
    //2.改造方法，把指标名称查询，上移，传参时候将 指标名称传下去。
    //3.组合范围数据

    // 缺数据的备注：理论缺数据的集合 与 查出来 缺数据的集合 做并集 ，将该并集作为真实的缺数据的集合，转string

    //有数据的备注：查出来有数据的集合 作为真实有数的集合 转string类型备注



    /**
     * 旬
     * 给定一个String类型的时间范围 startDate endDate 求出这个时间范围内旬的list
     * 获取 理论上 旬 的list。
     */
    @Test
    public void getXunList( ) throws ParseException {
        List<String> xunList = new ArrayList<>();
        String beginTime = "20190201";
        String endTime = "20190511";
        //1.根据给定日期算出一共多少个月,放到list
        List<String> dates = new ArrayList<>();
        //2.创建时间解析对象规定解析格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        //3.将传入的时间解析成Date类型,相当于格式化
        String beginMon = beginTime.substring(0, 6);
        String endMon = endTime.substring(0, 6);
        Date dBegin = sdf.parse(beginMon);
        Date dEnd = sdf.parse(endMon);
        //4.将格式化后的第一天添加进集合
        dates.add(sdf.format(dBegin));
        //5.使用本地的时区和区域获取日历
        Calendar calBegin = Calendar.getInstance();
        //6.传入起始时间将此日历设置为起始日历
        calBegin.setTime(dBegin);
        //8.判断结束日期是否在起始日历的日期之后
        while (dEnd.after(calBegin.getTime())) {
            // 9.根据日历的规则:月份中的每一天，为起始日历加一天
            calBegin.add(Calendar.MONTH, 1);
            //10.得到的每一天就添加进集合
            dates.add(sdf.format(calBegin.getTime()));
            //11.如果当前的起始日历超过结束日期后,就结束循环
        }
        int start = Integer.parseInt(beginTime.substring(6, 8));
        System.out.println(beginTime.substring(6, 8));
        System.out.println(beginTime.substring(0, 6));

        int end = Integer.parseInt(endTime.substring(6, 8));
        for (String month : dates) {
            if (month.equals(beginMon)) {
                if (start >= 1 && start <= 10) {
                    xunList.add(month + "01");
                    xunList.add(month + "02");
                    xunList.add(month + "03");
                } else if (start >= 11 && start <= 20) {
                    xunList.add(month + "02");
                    xunList.add(month + "03");
                } else if (start >= 21 && start <= 31) {
                    xunList.add(month + "03");
                }
            } else if (month.equals(endMon)) {
                if (end >= 1 && end <= 10) {
                    xunList.add(month + "01");
                } else if (end >= 11 && end <= 20) {
                    xunList.add(month + "01");
                    xunList.add(month + "02");
                } else if (end >= 21 && end <= 31) {
                    xunList.add(month + "01");
                    xunList.add(month + "02");
                    xunList.add(month + "03");
                }
            } else {
                xunList.add(month + "01");
                xunList.add(month + "02");
                xunList.add(month + "03");
            }
            System.out.println(xunList);
        }



    }

    /**
     * 日
     * 传入两个时间范围，返回这两个时间范围内的所有日期，并保存在一个集合中
     * @return
     * @throws ParseException
     */
    @Test
    public void findEveryDay() throws ParseException {
        String beginTime = "20190221";
        String endTime = "20190511";
        //1.创建一个放所有日期的集合
        List<String> dates = new ArrayList<>();
        //2.创建时间解析对象规定解析格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        //3.将传入的时间解析成Date类型,相当于格式化
        Date dBegin = sdf.parse(beginTime);
        Date dEnd = sdf.parse(endTime);
        //4.将格式化后的第一天添加进集合
        dates.add(sdf.format(dBegin));
        //5.使用本地的时区和区域获取日历
        Calendar calBegin = Calendar.getInstance();
        //6.传入起始时间将此日历设置为起始日历
        calBegin.setTime(dBegin);
        //8.判断结束日期是否在起始日历的日期之后
        while (dEnd.after(calBegin.getTime())) {
            // 9.根据日历的规则:月份中的每一天，为起始日历加一天
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            //10.得到的每一天就添加进集合
            dates.add(sdf.format(calBegin.getTime()));
            //11.如果当前的起始日历超过结束日期后,就结束循环
        }
        System.out.println(dates);
    }

    /**
     * 月
     *
     */
    @Test
    public void findEveryMon() throws ParseException {
        String beginTime = "20190201";
        String endTime = "20190511";
        //1.根据给定日期范围算出一共多少个月,放到list
        List<String> dates = new ArrayList<>();
        //2.创建时间解析对象规定解析格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        //3.将传入的时间解析成Date类型,相当于格式化
        String beginMon = beginTime.substring(0, 6);
        String endMon = endTime.substring(0, 6);
        Date dBegin = sdf.parse(beginMon);
        Date dEnd = sdf.parse(endMon);
        //4.将格式化后的第一个月添加进集合
        dates.add(sdf.format(dBegin));
        //5.使用本地的时区和区域获取日历
        Calendar calBegin = Calendar.getInstance();
        //6.传入起始时间将此日历设置为起始日历
        calBegin.setTime(dBegin);
        //8.判断结束日期是否在起始日历的日期之后
        while (dEnd.after(calBegin.getTime())) {
            // 9.根据日历的规则:月份中的每一天，为起始日历加一天
            calBegin.add(Calendar.MONTH, 1);
            //10.得到的每一天就添加进集合
            dates.add(sdf.format(calBegin.getTime()));
            //11.如果当前的起始日历超过结束日期后,就结束循环
        }
        System.out.println(dates);

    }

    /**
     * 季度
     *
     *
     */
    @Test
    public void findEveryQuarter() throws ParseException {
        List<String> quarterList = new ArrayList<>();
        String beginTime = "20190201";
        String endTime = "20210511";
        //1.
        List<String> dates = new ArrayList<>();
        //2.创建时间解析对象规定解析格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        //3.将传入的时间解析成Date类型,相当于格式化
        String beginYear = beginTime.substring(0, 4);
        String endYear = endTime.substring(0, 4);
        Date dBegin = sdf.parse(beginYear);
        Date dEnd = sdf.parse(endYear);
        //4
        dates.add(sdf.format(dBegin));
        //5.使用本地的时区和区域获取日历
        Calendar calBegin = Calendar.getInstance();
        //6.传入起始时间将此日历设置为起始日历
        calBegin.setTime(dBegin);
        //8.判断结束日期是否在起始日历的日期之后
        while (dEnd.after(calBegin.getTime())) {
            // 9.根据日历的规则:月份中的每一年，为起始日历加一年
            calBegin.add(Calendar.YEAR, 1);
            //10.得到的每一年就添加进集合
            dates.add(sdf.format(calBegin.getTime()));
            //11.如果当前的起始日历超过结束日期后,就结束循环
        }
        int start = Integer.parseInt(beginTime.substring(4, 6));
        int end = Integer.parseInt(endTime.substring(4, 6));
        for (String year : dates) {
            if (year.equals(beginYear)) {
                if (start >= 1 && start <= 3) {
                    quarterList.add(year + "01");
                    quarterList.add(year + "02");
                    quarterList.add(year + "03");
                    quarterList.add(year + "04");
                } else if (start >= 4 && start <= 6) {
                    quarterList.add(year + "02");
                    quarterList.add(year + "03");
                    quarterList.add(year + "04");
                } else if (start >= 7 && start <= 9) {
                    quarterList.add(year + "03");
                    quarterList.add(year + "04");
                } else if (start >= 10 && start <= 12) {
                    quarterList.add(year + "04");
                }
            }else if (year.equals(endYear)) {
                if (end >= 1 && end <= 3) {
                    quarterList.add(year + "01");
                } else if (end >= 4 && end <= 6) {
                    quarterList.add(year + "01");
                    quarterList.add(year + "02");
                } else if (end >= 7 && end <= 9) {
                    quarterList.add(year + "01");
                    quarterList.add(year + "02");
                    quarterList.add(year + "03");
                } else if (end >= 10 && end <= 12) {
                    quarterList.add(year + "01");
                    quarterList.add(year + "02");
                    quarterList.add(year + "03");
                    quarterList.add(year + "04");
                }
            } else {
                quarterList.add(year + "01");
                quarterList.add(year + "02");
                quarterList.add(year + "03");
                quarterList.add(year + "04");
            }
            System.out.println(quarterList);
        }
    }

    /**
     * 周
     *
     *
     */
    @Test
    public void findEveryWeek() throws ParseException {
        String beginTime = "20190201";
        String endTime = "20200511";
        //1.根据给定日期算出一共多少个年,放到list
        List<String> dates = new ArrayList<>();
        //2.创建时间解析对象规定解析格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        //3.将传入的时间解析成Date类型,相当于格式化
        Date dBegin = sdf.parse(beginTime);
        Date dEnd = sdf.parse(endTime);
        //4.将格式化后的第一天添加进集合
        dates.add(sdf.format(dBegin).substring(0,4));
        //5.使用本地的时区和区域获取日历
        Calendar calBegin = Calendar.getInstance();
        //6.传入起始时间将此日历设置为起始日历
        calBegin.setTime(dBegin);
        int start = calBegin.get(Calendar.WEEK_OF_YEAR);
        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(dEnd);
        int end = calEnd.get(Calendar.WEEK_OF_YEAR);
        System.out.println(end);
        //8.判断结束日期是否在起始日历的日期之后，起始年，结束年
        while (dEnd.after(calBegin.getTime())) {
            // 9.根据日历的规则:起始年，结束年，为起始日历加一年
            calBegin.add(Calendar.YEAR, 1);
            //10.得到的每一天就添加进集合
            if(sdf.format(calBegin.getTime()).substring(0,4).equals(endTime.substring(0,4))) {
                dates.add(sdf.format(calBegin.getTime()).substring(0,4));
                break;
            }
            //11.如果当前的起始日历超过结束日期后,就结束循环
        }
        List<String> weeks = new ArrayList<>();
        for(String year : dates) {
            //如果是起始年
            if(year.equals(beginTime.substring(0,4))) {
                //获取开始时间范围内的第一个周
                for(int i=start;i<=52;i++) {
                    String week = i<10 ? (year + "0" + i) : (year + i);
                    weeks.add(week);
                }

            }else if(year.equals(endTime.substring(0,4))) {
                //获取结束时间范围内的最后一个周
                for(int i=1;i<=end;i++) {
                    String week = i<10 ? (year + "0" + i) : (year + i);
                    weeks.add(week);
                }
            }else {
                for(int i=1;i<=52;i++) {
                    String week = i<10 ? (year + "0" + i) : (year + i);
                    weeks.add(week);
                }
            }
        }
        System.out.println(dates);
        System.out.println(weeks);
    }

    /**
     * 年
     *
     *
     */
    @Test
    public void findEveryYear() throws ParseException {
        String beginTime = "20190201";
        String endTime = "20200511";
        //1.根据给定日期算出一共多少个年,放到list
        List<String> dates = new ArrayList<>();
        //2.创建时间解析对象规定解析格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        //3.将传入的时间解析成Date类型,相当于格式化
        Date dBegin = sdf.parse(beginTime);
        Date dEnd = sdf.parse(endTime);
        //4.将格式化后的第一天添加进集合
        dates.add(sdf.format(dBegin).substring(0,4));
        //5.使用本地的时区和区域获取日历
        Calendar calBegin = Calendar.getInstance();
        //6.传入起始时间将此日历设置为起始日历
        calBegin.setTime(dBegin);
        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(dEnd);
        //8.判断结束日期是否在起始日历的日期之后，起始年，结束年
        while (dEnd.after(calBegin.getTime())) {
            // 9.根据日历的规则:起始年，结束年，为起始日历加一年
            calBegin.add(Calendar.YEAR, 1);
            //10.得到的每一天就添加进集合
            if(sdf.format(calBegin.getTime()).substring(0,4).equals(endTime.substring(0,4))) {
                dates.add(sdf.format(calBegin.getTime()).substring(0,4));
                break;
            }
            //11.如果当前的起始日历超过结束日期后,就结束循环
        }

        System.out.println(dates);
    }


    /**
     * 半年
     *
     *
     */
    @Test
    public void findEveryHalfYear() throws ParseException {
        List<String> quarterList = new ArrayList<>();
        String beginTime = "20190201";
        String endTime = "20210511";
        //1.
        List<String> dates = new ArrayList<>();
        //2.创建时间解析对象规定解析格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        //3.将传入的时间解析成Date类型,相当于格式化
        String beginYear = beginTime.substring(0, 4);
        String endYear = endTime.substring(0, 4);
        Date dBegin = sdf.parse(beginYear);
        Date dEnd = sdf.parse(endYear);
        //4
        dates.add(sdf.format(dBegin));

        //5.使用本地的时区和区域获取日历
        Calendar calBegin = Calendar.getInstance();
        //6.传入起始时间将此日历设置为起始日历
        calBegin.setTime(dBegin);
        //8.判断结束日期是否在起始日历的日期之后
        while (dEnd.after(calBegin.getTime())) {
            // 9.根据日历的规则:月份中的每一年，为起始日历加一年
            calBegin.add(Calendar.YEAR, 1);
            //10.得到的每一年就添加进集合
            dates.add(sdf.format(calBegin.getTime()));
            //11.如果当前的起始日历超过结束日期后,就结束循环
        }
        int start = Integer.parseInt(beginTime.substring(4, 6));
        int end = Integer.parseInt(endTime.substring(4, 6));
        for (String year : dates) {
            if (year.equals(beginYear)) {
                if (start >= 1 && start <= 6) {
                    quarterList.add(year + "01");
                    quarterList.add(year + "02");
                } else if (start >= 7 && start <= 12) {
                    quarterList.add(year + "02");
                }
            }else if (year.equals(endYear)) {
                if (end >= 1 && end <= 6) {
                    quarterList.add(year + "01");
                } else if (end >= 7 && end <= 12) {
                    quarterList.add(year + "01");
                    quarterList.add(year + "02");
                }
            } else {
                quarterList.add(year + "01");
                quarterList.add(year + "02");
            }
            System.out.println(quarterList);
        }
    }

}





