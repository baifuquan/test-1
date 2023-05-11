package com.example.test.test10;


import java.util.*;
import java.util.stream.Collectors;

public class MainUser {
    /**
     * 构造一个集合
     */
    public static List<User> getUserList() {
        User user1 = new User(1, "张", "A");
        User user2 = new User(2, "李", "BB");
        User user3 = new User(3, "王", "BB");
        User user4 = new User(4, "马", "CCC");
        User user5 = new User(5, "赵", "CCC");
        User user6 = new User(6, "钱", "CCC");

        List<User> list = new ArrayList<>();
        list.add(user2);
        list.add(user4);
        list.add(user3);
        list.add(user1);
        list.add(user5);
        list.add(user6);

        return list;
    }

    /**
     * 打印出所有的 key 及 对应list中的元素
     */
    private static void print(Map<String, List<User>> groupMap) {
        groupMap.forEach((key, list) -> {
            System.out.println(key);
            list.forEach(System.out::println);
        });
    }

    public static void main(String[] args) {
        List<User> list = getUserList();
        //根据 id 升序
        list = list.stream().sorted(Comparator.comparing(User::getId)).collect(Collectors.toList());
        list.forEach(System.out::println);
        System.out.println();

        //（1）这样分组，key 是无序的
        Map<String, List<User>> groupMap1 = list.stream().collect(Collectors.groupingBy(User::getType));
        print(groupMap1);

        System.out.println();

        //（2）这样分组，key 还是原来的顺序
        Map<String, List<User>> groupMap2 = list.stream().collect(Collectors.groupingBy(User::getType, LinkedHashMap::new, Collectors.toList()));
// LinkedHashMap<String, List<User>> groupMap2 = list.stream().collect(Collectors.groupingBy(User::getType, LinkedHashMap::new, Collectors.toList()));
        print(groupMap2);
    }

}
