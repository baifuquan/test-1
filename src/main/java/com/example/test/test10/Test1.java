package com.example.test.test10;

import org.junit.Test;

import java.util.*;

public class Test1 {
    //首先来看看Map集合获取元素的三种常见方法keySet()、values()、entrySet()
    public static void main(String[] args){

    }

    @Test
    public void values() {
        Map<String, String> map = new HashMap<>();  //构建键值对为<String, String>的Map集合
        map.put("a", "aaa");
        map.put("b", "bbb");
        map.put("c", "ccc");
        Collection<String> collection = map.values();  //获取map集合的所有value的Collection集合（于集合中无序存放）
        System.out.println(collection);

    }

    @Test
    public void keySet() {
        Map<String, String> map = new HashMap<String, String>();  //构建键值对为<String, String>的Map集合
        map.put("a", "aaa");
        map.put("b", "bbb");
        map.put("c", "ccc");

        Set<String> keySet = map.keySet();  //获取map集合的所有键的Set集合（于Set集合中无序存放）
        Iterator<String> iter = keySet.iterator();  //获取keySet集合的迭代器
        while(iter.hasNext()){
            String key = iter.next();
            String value = map.get(key);
            System.out.println("key:" + key + "-->value:" + value);
        }

    }

    @Test
    public void entrySet() {
        Map<String, String> map = new HashMap<String, String>();  //构建键值对为<String, String>的Map集合
        map.put("a", "aaa");
        map.put("b", "bbb");
        map.put("c", "ccc");

        Set<Map.Entry<String, String>> entrySet = map.entrySet();  //获取map集合的所有"映射"的Set集合,这里规范每个映射的类型为Map.Entry<K, V>（于Set集合中无序存放）
        Iterator<Map.Entry<String, String>> iter = entrySet.iterator();  //获取entrySet集合的迭代器,Map.Entry<K, V>为迭代元素的类型
        while(iter.hasNext()){
            Map.Entry<String, String> item = iter.next();
            String key = item.getKey();
            String value = item.getValue();
            System.out.println("key:" + key + "-->value:" + value);
        }

    }

}
