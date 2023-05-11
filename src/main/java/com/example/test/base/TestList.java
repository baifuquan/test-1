package com.example.test.base;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;


public class TestList {

    public static void main(String[] args) {
        Fact fact = new Fact();
        fact.setCompany("北京");
        fact.setSort(300L);
        System.out.println(fact);
        HashMap<String,Long> hm = new HashMap<>();
        hm.put(fact.getCompany(), fact.getSort());
        System.out.println(hm);
    }

    @Test
    public void test1() {
        //list 赋值
        String[] strArr = {"1111111","22222222","3333333","444444"};
        List<String> stringList = new ArrayList<>();
        stringList.add("1111");
        stringList.add("22222");
        stringList.add("33333");

        System.out.println(stringList);
        List<String> stringList22 = new ArrayList<>();
        stringList22 = stringList;
        System.out.println(stringList22);

        List<String> stringList322= new ArrayList<>();
        stringList322.add("222");
        stringList322.add("333");

        List<String> stringList333 = new ArrayList<>(stringList);
        System.out.println(stringList333);

        stringList322.indexOf("333");

        System.out.println(stringList322.indexOf("3393"));

        String point_num = "2";
        String value2 = "0.0345564";
        System.out.println(value2);

        value2 = new BigDecimal(value2).multiply(new BigDecimal(100)).setScale(Integer.parseInt(point_num),BigDecimal.ROUND_HALF_UP).toString();
        System.out.println(value2);



    }
}
