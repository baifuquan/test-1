package com.example.test.base.list;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class TestList {

    //求交集、并集、差集
    @Test
    public void test1() {
        List<String> dates1 = new ArrayList<>();
        dates1.add("20190101");
        dates1.add("20190102");
        dates1.add("20190103");
        dates1.add("20190104");
        dates1.add("20190105");
        dates1.add("20190106");
        dates1.add("20190107");
        dates1.add("20190108");
        List<String> dates2 = new ArrayList<>();
        dates2.add("20190106");
        dates2.add("20190107");
        dates2.add("20190108");
        dates2.add("20190109");
        dates2.add("20190110");
        dates2.add("20190111");
        dates2.add("20190112");
        //求交集 dates1 dates2
        List<String> jiaoji =  dates1.stream().filter(dates2::contains).collect(Collectors.toList());
        List<String> jiao = dates1.stream().filter(item->dates2.contains(item)).collect(toList());
        System.out.println("jiaoji");
        System.out.println(jiaoji);
        System.out.println(jiao);

        //求差集 dates1 - dates2
        List<String> chaji = dates1.stream().filter(item->!dates2.contains(item)).collect(toList());
        List<String> cha = dates1.stream().filter(item->!dates2.contains(item)).collect(Collectors.toList());
        System.out.println();
        System.out.println("chaji");
        System.out.println(chaji);
        System.out.println(cha);
        //dates2 - dates1
        List<String> dates2_1 = dates2.stream().filter(item->!dates1.contains(item)).collect(toList());
        System.out.println("dates2 - dates1");
        System.out.println(dates2_1);

        //求并集 dates1 + dates2
        List<String> datesall1 = dates1.parallelStream().collect(toList());
        List<String> datesall2 = dates2.parallelStream().collect(toList());
        datesall1.addAll(datesall2);
        System.out.println();
        System.out.println("求并集 datesall1 = dates1 + dates2");
        System.out.println(datesall1);
        //去重并集
        List<String> distinctAll = datesall1.stream().distinct().collect(toList());
        System.out.println();
        System.out.println("去重并集  distinctAll = dates1 + dates2");

        System.out.println();
        System.out.println(distinctAll);
    }

    //list 去重
    @Test
    public void testListDistinct() {
        List<String> dates1 = new ArrayList<>();
        dates1.add("20190104");
        dates1.add("20190103");
        dates1.add("20190101");
        dates1.add("20190102");
        dates1.add("20190105");
        dates1.add("20190106");
        dates1.add("20190107");
        dates1.add("20190108");
        dates1.add("20190106");
        dates1.add("20190107");
        dates1.add("20190108");
        dates1.add("20190109");
        dates1.add("20190110");
        dates1.add("20190111");
        dates1.add("20190112");
        System.out.println("原生集合");
        System.out.println(dates1);
        listDistinct1(dates1);
        listDistinct2(dates1);
        listDistinct3(dates1);
        listDistinct4(dates1);
        listDistinct5(dates1);
    }
    /**
     *  1.HashSet去重
     *  我们知道 HashSet 天生具备“去重”的特性，那我们只需要将 List 集合转换成 HashSet 集合就可以了，实现代码如下
     */
    public void listDistinct1(List<String> list){
        HashSet<String> hashSet = new HashSet<>(list);
        System.out.println("HashSet去重");
        System.out.println(hashSet);
    }
    /**
     * 2.TreeSet去重
     * 除了HashSet集合之外，我们还可以使用 TreeSet 集合来实现去重功能，实现代码如下：
     */
    public void listDistinct2(List<String> list) {
        TreeSet<String> treeSet = new TreeSet<>(list);
        System.out.println("TreeSet去重");
        System.out.println(treeSet);
    }
    /**
     * 3.LinkedHashSet 去重
     * 如果上面的Set 不能满足需求，那就使用 LinkedHashSet，它既能去重又能保证集合的顺序，实现代码如下：
     */
    public void listDistinct3(List<String> list) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(list);
        System.out.println("LinkedHashSet 去重");
        System.out.println(linkedHashSet);
    }
    /**
     * 4.迭代器去重
     * 使用迭代器循环判断每一项数据，如果当前循环的数据，在集合中存在两份或两份以上，就将当前的元素删除掉，这样循环完之后，即可得到一个没有重复数据的集合
     */
    public void listDistinct4(List<String> list) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            //获取循环的值
            String item = iterator.next();
            //如果存在两个相同的值
            if(list.indexOf(item) != list.lastIndexOf(item)){
                //移除最后那个相同的值
                iterator.remove();
            }
        }
        System.out.println("迭代器去重 Iterator 去重");
        System.out.println(list);
    }

    /**
     * 5.使用 Stream 去重
     * JDK 8 为我们带来了一个非常实用的方法 Stream，使用它可以实现很多功能。（个人感觉Stream很好用）
     */
    public void listDistinct5(List<String> list){
        List<String> distinctList = list.stream().distinct().collect(toList());
        System.out.println("Stream 去重");
        System.out.println(distinctList);
    }


}
