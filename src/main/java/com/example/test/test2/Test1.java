package com.example.test.test2;

import cn.hutool.json.JSONUtil;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * @author : jiabiao
 * @date : 2021/11/18 17:23
 * @className : Test1
 * @description : 测试
 **/
public class Test1 {

    List<Student> studentList = new ArrayList<>();

    {
        studentList.add(new Student(1, "张1", 11));
        studentList.add(new Student(2, "张2", 12));
        studentList.add(new Student(3, "张3", 13));
        studentList.add(new Student(4, "张4", 14));
        studentList.add(new Student(5, "张5", 15));
    }

    @Test
    public void test1111() {
        System.out.println(studentList);
        System.out.println(studentList.get(0));
        studentList.remove(0);
        System.out.println(studentList);
        System.out.println(studentList.get(0));
        studentList.remove(0);
        System.out.println(studentList);
//        System.out.println(studentList.get(1));
//        System.out.println(studentList.get(2));
//        System.out.println(studentList.get(3));
//        System.out.println(studentList.get(4));
    }

    /**
     * forEach可以修改元素
     */
    @Test
    public void test1() {

        studentList.forEach(item -> item.setName("李四"));
        //forEach无返回值，后续不能再操作了
        System.out.println(JSONUtil.toJsonStr(studentList));

        //stream操作的参数是一个函数对象
        Consumer<Student> c = new Consumer<Student>() {
            @Override
            public void accept(Student student) {
                student.setName("李四");
            }
        };
        studentList.forEach(c);

        System.out.println(JSONUtil.toJsonStr(studentList));
    }

    /**
     * peek不能修改元素，一般不用这个
     */
    @Test
    public void test2() {
        studentList.stream()
                .peek(item -> item.setName("李四"));
        System.out.println(JSONUtil.toJsonStr(studentList));

        studentList = studentList.stream()
                .peek(item -> item.setName("李四"))
                .collect(Collectors.toList());
        System.out.println(JSONUtil.toJsonStr(studentList));
    }

    /**
     * filter条件判断
     */
    @Test
    public void test3() {
        studentList = studentList.stream()
                .filter(item -> item.getId() > 3)
                .filter(item -> item.getName().startsWith("张"))
                .collect(Collectors.toList());
        System.out.println(JSONUtil.toJsonStr(studentList));

        studentList.add(new Student(5, null, 15));
        studentList = studentList.stream()
                .filter(Objects::nonNull)
                .filter(item -> null != item.getName())
                .filter(item -> item.getId() > 3)
                .filter(item -> item.getName().startsWith("张"))
                .collect(Collectors.toList());
        System.out.println(JSONUtil.toJsonStr(studentList));
    }

    /**
     * match 条件判断
     */
    @Test
    public void test4() {
        //任意一个元素true
        boolean match1 = studentList.stream()
                .anyMatch(item -> item.getId() > 3);
        System.out.println(match1);

        //全部元素true
        boolean match2 = studentList.stream()
                .allMatch(item -> item.getId() > 3);
        System.out.println(match2);

        //全部元素false
        boolean match3 = studentList.stream()
                .noneMatch(item -> item.getId() > 3);
        System.out.println(match3);
    }

    /**
     * map替换
     */
    @Test
    public void test5() {
        List<Map<String, String>> maps = studentList.stream()
                .map(item -> {
                    Map<String, String> map = new HashMap<>();
                    map.put("name", item.getName());
                    return map;
                })
                .collect(Collectors.toList());
        System.out.println(JSONUtil.toJsonStr(maps));

        List<String> collect = studentList.stream()
                .map(Student::getName)
                .collect(Collectors.toList());
        System.out.println(JSONUtil.toJsonStr(collect));
    }

    /**
     * groupingBy分组
     */
    @Test
    public void test6() {
        Map<Integer, List<Student>> collect = studentList.stream()
                .collect(Collectors.groupingBy(Student::getId));
        System.out.println(JSONUtil.toJsonStr(collect));

        Map<String, List<Student>> collect1 = studentList.stream()
                .collect(Collectors.groupingBy(item -> item.getName().substring(0, 1)));
        System.out.println(JSONUtil.toJsonStr(collect1));

        Map<String, Integer> collect2 = studentList.stream()
                .collect(Collectors.groupingBy(item -> item.getName().substring(0, 1),
                        Collectors.summingInt(Student::getAge)));
        System.out.println(JSONUtil.toJsonStr(collect2));

        Map<String, String> collect3 = studentList.stream()
                .collect(Collectors.toMap(item -> item.getName().substring(0, 1),
                        Student::getName,
                        (a, b) -> a));
        System.out.println(JSONUtil.toJsonStr(collect3));

    }

    /**
     * BigDecimal求和
     */
    @Test
    public void test7() {
        List<BigDecimal> list = new ArrayList<>();
        list.add(new BigDecimal(1));
        list.add(new BigDecimal(7));
        list.add(new BigDecimal(20));

        //给初始值
        BigDecimal reduce = list.stream()
                .reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
        System.out.println(reduce.toPlainString());

        //不给初始值
        Optional<BigDecimal> reduce1 = list.stream()
                .reduce((a, b) -> a.add(b));
        System.out.println(reduce1.get().toPlainString());

    }

    /**
     * int,long,double求和
     */
    @Test
    public void test8() {
        double sum1 = studentList.stream()
                .mapToDouble(Student::getAge)
                .sum();
        System.out.println(sum1);

        OptionalDouble reduce = studentList.stream()
                .mapToDouble(Student::getAge)
                .reduce(Double::sum);
        System.out.println(reduce.getAsDouble());

    }


    /**
     * Optional
     */
    @Test
    public void test9() {
        List<BigDecimal> list = new ArrayList<>();

        //orElse参数对象已经实例化了
        BigDecimal reduce3 = list.stream()
                .reduce(BigDecimal::add)
                .orElse(new BigDecimal(777));
        System.out.println(reduce3.toPlainString());

        //orElse参数是个函数，返回值对象还没实例化
        BigDecimal reduce4 = list.stream()
                .reduce(BigDecimal::add)
                .orElseGet(() -> {
                    System.out.println("返回自定义结果");
                    return new BigDecimal(123);
                });
        System.out.println(reduce4.toPlainString());

        //存在结果则执行
        Optional<BigDecimal> reduce = list.stream()
                .reduce(BigDecimal::add);
        reduce.ifPresent(item -> System.out.println("结果不为空 " + item));
    }

    /**
     * distinct去重
     */
    @Test
    public void test10() {
        studentList.add(new Student(1, "张1", 11));
        studentList.add(new Student(2, "张2", 12));
        studentList.add(new Student(3, "张3", 13));
        studentList.add(new Student(4, "张4", 14));
        studentList.add(new Student(5, "张5", 15));
        System.out.println(studentList.size());

        List<Student> collect = studentList.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect.size());
    }

    /**
     * 并行流
     */
    @Test
    public void test11() throws ExecutionException, InterruptedException {
        studentList.parallelStream().forEach(System.out::println);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(1);
        }

        //ArrayList不是线程安全的
        List<Integer> list2 = new ArrayList<>();
        //串行操作
        list.stream().forEach(list2::add);
        System.out.println(list2.size());

        list2.clear();
        //并行操作
        list.parallelStream().forEach(list2::add);
        System.out.println(list2.size());

        //避免访问公共数据，使用collect聚合
        List<Integer> list3 = list.parallelStream()
                .filter(item -> item > 0)
                .collect(Collectors.toList());
        System.out.println(list3.size());

        //指定并行线程数
        ForkJoinPool customThreadPool = new ForkJoinPool(10);
        ForkJoinTask<List<Integer>> result = customThreadPool.submit(() -> list.parallelStream()
                .filter(item -> item > 0)
                .collect(Collectors.toList()));
        System.out.println(result.get().size());
    }

    @Test
    public void test12() {
        //最大
        Optional<Student> max = studentList.stream()
                .max(Comparator.comparing(Student::getId));
        max.ifPresent(System.out::println);

        //最小
        Optional<Student> min = studentList.stream()
                .min(Comparator.comparing(Student::getId));
        min.ifPresent(System.out::println);

        //第一个元素
        Optional<Student> first = studentList.stream()
                .findFirst();
        first.ifPresent(System.out::println);

        //任意元素，串行返回第一个
        Optional<Student> any = studentList.stream()
                .findAny();
        any.ifPresent(System.out::println);

        //任意元素，并行随机返回
        Optional<Student> any2 = studentList.parallelStream()
                .findAny();
        any2.ifPresent(System.out::println);
    }


    @Test
    public void test13() {
        studentList.stream().map(item -> {
            System.out.println("7777");
            return "true";
        }).collect(Collectors.toList());
    }

    @Test
    public void test14() {
        BigDecimal aa = new BigDecimal("100");
        System.out.println(aa.multiply(new BigDecimal("-1")));
    }

}
