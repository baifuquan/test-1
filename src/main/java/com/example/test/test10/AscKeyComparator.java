package com.example.test.test10;


import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.*;


public class AscKeyComparator{

    public static void main(String[] args){
        Map<String, Integer> map = new HashMap<String, Integer>();
        List<String> test1 = new ArrayList<>();
        test1.add("111111");
        test1.add("111111");
        test1.add("111111");

        String dd = StringUtils.join(test1,",");
        System.out.println(dd);

        List<String> test2 = new ArrayList<>();
        test2.add("222222");
        test2.add("222222");
        test2.add("222222");
        List<String> test3 = new ArrayList<>();
        test3.add("333333");
        test3.add("333333");
        test3.add("333333");
        List<String> test4 = new ArrayList<>();
        test4.add("444444");
        test4.add("444444");
        test4.add("444444");
        List<String> test5 = new ArrayList<>();
        test5.add("555555");
        test5.add("555555");
        test5.add("555555");
        List<String> test6 = new ArrayList<>();
        test6.add("666666");
        test6.add("666666");
        test6.add("666666");
        HashMap<String, List<String>> maptest =new  HashMap<String, List<String>>();
        maptest.put("202202",test1);
        maptest.put("200002",test2);
        maptest.put("200102",test3);
        maptest.put("201002",test4);
        maptest.put("201402",test5);
        maptest.put("201302",test6);

        Collection<String> keyset= maptest.keySet();
        List<String> list = new ArrayList<String>(keyset);

        //对key键值按字典升序排序
        Collections.sort(list);
        System.out.println(list);
        HashMap<String,String> maptestNew =new  HashMap<String, String>();

        for (int i = 0; i < list.size(); i++) {
            System.out.println("key键---值: "+list.get(i)+","+maptest.get(list.get(i)));
            maptestNew.put(list.get(i),maptest.get(list.get(i)).toString());
        }

        System.out.println(maptest);
        System.out.println(maptestNew);

    }

    @Test
    public void getsort(){
        Map<String, Integer> map = new HashMap<String, Integer>();
        List<String> test1 = new ArrayList<>();
        test1.add("111111");
        test1.add("111111");
        test1.add("111111");
        String dd = StringUtils.join(test1,",");
        System.out.println(dd);


        List<String> test2 = new ArrayList<>();
        test2.add("222222");
        test2.add("222222");
        test2.add("222222");
        List<String> test3 = new ArrayList<>();
        test3.add("333333");
        test3.add("333333");
        test3.add("333333");
        List<String> test4 = new ArrayList<>();
        test4.add("444444");
        test4.add("444444");
        test4.add("444444");
        List<String> test5 = new ArrayList<>();
        test5.add("555555");
        test5.add("555555");
        test5.add("555555");
        List<String> test6 = new ArrayList<>();
        test6.add("666666");
        test6.add("666666");
        test6.add("666666");
        HashMap<String, List<String>> maptest =new  HashMap<String, List<String>>();
        maptest.put("202202",test1);
        maptest.put("200002",test2);
        maptest.put("200102",test3);
        maptest.put("201002",test4);
        maptest.put("201402",test5);
        maptest.put("201302",test6);

        System.out.println("根据map的key升序：" + sortByKey(maptest, false));
    }


    private  <K extends Comparable<? super K>, V> Map<K, V> sortByKey(Map<K, V> map, boolean isDesc) {
        Map<K, V> result = Maps.newLinkedHashMap();
        if (isDesc) {
            map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByKey().reversed())
                    .forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        } else {
            map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByKey())
                    .forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        }
        return result;
    }
}

