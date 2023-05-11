package com.example.test.test9;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


public class Test2 {


    @Test
    public void test() throws ParseException {
        String cal_cycle = "2";
        System.out.println(getPreiodsRange(cal_cycle));
    }

    public Map<String, List<String>> getPreiodsRange(String cal_cycle) throws ParseException {

        HashMap<String, List<String>> hm = new HashMap<>();
        //增量数据范围：2021年1月1日到现在
        String inCrBeginTime = "20210101";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        Date nowDate = new Date();
        String inCrEndTime = sdf.format(nowDate);
        List<String> inCrPreiodsRange = findA11Periods(inCrBeginTime, inCrEndTime, cal_cycle).stream().distinct().collect(Collectors.toList());
        //增量数据范围各种期别类型的查询截止日期为当前时间的上一期
        inCrPreiodsRange.remove(inCrPreiodsRange.size() - 1);
        hm.put("incr", inCrPreiodsRange);
        //历史数据范围：2018年1月到2020年12月
        String hisBeginTime = "20180101";
        String hisEndTime = "20201231";
        List<String> hisPreiodsRange = findA11Periods(hisBeginTime, hisEndTime, cal_cycle).stream().distinct().collect(Collectors.toList());
        hm.put("his", hisPreiodsRange);
        return hm;
    }


    @Test
    public void test1() throws ParseException {
        String cal_cycle = "4";
        String beginTime = "20190501";
        String endTime = "20210531";
        List<String>  strList = findA11Periods(beginTime, endTime, cal_cycle);
        System.out.println(StringUtils.join(strList.toArray(),","));
    }

    private List<String> findA11Periods(String beginTime, String endTime, String cycle) throws ParseException {
        List<String> periodsList = new ArrayList<>();
        List<String> dates = new ArrayList<>();
        if ("1".equals(cycle)) {
            //年
            List<String> yearList = new ArrayList<>();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            String beginYear = beginTime.substring(0, 4);
            String endYear = endTime.substring(0, 4);
            Date dBegin = sdf.parse(beginYear);
            Date dEnd = sdf.parse(endYear);
            yearList.add(sdf.format(dBegin));
            Calendar calBegin = Calendar.getInstance();
            calBegin.setTime(dBegin);
            while (dEnd.after(calBegin.getTime())) {
                calBegin.add(Calendar.YEAR, 1);
                yearList.add(sdf.format(calBegin.getTime()));
            }
            periodsList = yearList;
        }
        if ("2".equals(cycle)) {
            //半年
            List<String> halfYearList = new ArrayList<>();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            String beginYear = beginTime.substring(0, 4);
            String endYear = endTime.substring(0, 4);
            Date dBegin = sdf.parse(beginYear);
            Date dEnd = sdf.parse(endYear);
            dates.add(sdf.format(dBegin));
            Calendar calBegin = Calendar.getInstance();
            calBegin.setTime(dBegin);
            while (dEnd.after(calBegin.getTime())) {
                calBegin.add(Calendar.YEAR, 1);
                dates.add(sdf.format(calBegin.getTime()));
            }
            int start = Integer.parseInt(beginTime.substring(4, 6));
            int end = Integer.parseInt(endTime.substring(4, 6));
            for (String year : dates) {
                if (year.equals(beginYear)) {
                    if (start >= 1 && start <= 6) {
                        halfYearList.add(year + "01");
                        halfYearList.add(year + "02");
                    } else if (start >= 7 && start <= 12) {
                        halfYearList.add(year + "02");
                    }
                } else if (year.equals(endYear)) {
                    if (end >= 1 && end <= 6) {
                        halfYearList.add(year + "01");
                    } else {
                        halfYearList.add(year + "01");
                        halfYearList.add(year + "02");
                    }
                } else {
                    halfYearList.add(year + "01");
                    halfYearList.add(year + "02");
                }
            }
            periodsList = halfYearList;
        }
        if ("3".equals(cycle)) {
            //季
            List<String> seasonList = new ArrayList<>();
            //开始年份
            List<String> yearList = new ArrayList<>();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            String beginYear = beginTime.substring(0, 4);
            String endYear = endTime.substring(0, 4);
            Date dBegin = sdf.parse(beginYear);
            Date dEnd = sdf.parse(endYear);
            yearList.add(sdf.format(dBegin));
            Calendar calBegin = Calendar.getInstance();
            calBegin.setTime(dBegin);
            while (dEnd.after(calBegin.getTime())) {
                calBegin.add(Calendar.YEAR, 1);
                yearList.add(sdf.format(calBegin.getTime()));
            }
            int startMon = Integer.parseInt(beginTime.substring(4, 6));
            int endMon = Integer.parseInt(endTime.substring(4, 6));

            for (String year : yearList) {
                if (year.equals(beginYear)) {
                    if (startMon >= 1 && startMon <= 3) {
                        seasonList.add(year + "01");
                        seasonList.add(year + "02");
                        seasonList.add(year + "03");
                        seasonList.add(year + "04");
                    }
                    if (startMon >= 4 && startMon <= 6) {
                        seasonList.add(year + "02");
                        seasonList.add(year + "03");
                        seasonList.add(year + "04");
                    }
                    if (startMon >= 7 && startMon <= 9) {
                        seasonList.add(year + "03");
                        seasonList.add(year + "04");
                    }
                    if (startMon >= 10 && startMon <= 12) {
                        seasonList.add(year + "04");
                    }

                } else if (year.equals(endYear)) {
                    if (endMon >= 1 && endMon <= 3) {
                        seasonList.add(year + "01");
                    }
                    if (endMon >= 4 && endMon <= 6) {
                        seasonList.add(year + "01");
                        seasonList.add(year + "02");
                    }
                    if (endMon >= 7 && endMon <= 9) {
                        seasonList.add(year + "01");
                        seasonList.add(year + "02");
                        seasonList.add(year + "03");
                    }
                    if (endMon >= 10 && endMon <= 12) {
                        seasonList.add(year + "01");
                        seasonList.add(year + "02");
                        seasonList.add(year + "03");
                        seasonList.add(year + "04");
                    }
                } else {
                    seasonList.add(year + "01");
                    seasonList.add(year + "02");
                    seasonList.add(year + "03");
                    seasonList.add(year + "04");
                }
            }
            periodsList = seasonList;
        }
        if ("4".equals(cycle)) {
            //月
            //1.根据给定日期范围算出一共多少个月,放到list
            List<String> monList = new ArrayList<>();
            //2.创建时间解析对象规定解析格式
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
            //3.将传入的时间解析成Date类型,相当于格式化
            String beginMon = beginTime.substring(0,6);
            String endMon = endTime.substring(0,6);
            Date dBegin = sdf.parse(beginMon);
            Date dEnd = sdf.parse(endMon);
            //4.将格式化后的第一个月添加进集合
            monList.add(sdf.format(dBegin));
            //5.使用本地的时区和区域获取日历
            Calendar calBegin = Calendar.getInstance();
            //6.传入起始时间将此日历设置为起始日历
            calBegin.setTime(dBegin);
            //7.判断结束日期是否在起始日历的日期之后
            while (dEnd.after(calBegin.getTime())) {
                // 8.根据日历的规则:为起始日历加一月
                calBegin.add(Calendar.MONTH,1);
                //9.得到的每一月就添加进集合
                monList.add(sdf.format(calBegin.getTime()));
            }
            periodsList = monList;
        }
        if ("5".equals(cycle)) {
            //旬
            List<String> xunList = new ArrayList<>();

            periodsList = xunList;
        }
        if ("6".equals(cycle)) {
            //周
            List<String> weeksList = new ArrayList<>();

            periodsList = weeksList;
        }
        if ("7".equals(cycle)) {
            //日
            List<String> daysList = new ArrayList<>();
            periodsList = daysList;
        }

        return periodsList;
    }

}
