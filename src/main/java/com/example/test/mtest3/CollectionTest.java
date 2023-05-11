package com.example.test.mtest3;

import org.junit.Test;

import java.util.*;

/**
 * @author : baifuquan
 * @date : 2022/6/21 12:07
 * @className : CollectionTest
 * @description : CollectionTest
 **/
public class CollectionTest {

    public static void main (String[] args) {

    }
    @Test
    public void list1() {
        List<Integer> integers = new ArrayList<>();
        // LinkedList 没有同步方法，
        // 创建同步方法Collections.synchronizedList(new LinkedList<>());
        LinkedList<Integer> linkedList = new LinkedList<>();
        List<Integer> list = Collections.synchronizedList(new LinkedList<>());

        // ArrayList 没有同步方法
        // 创建同步方法 Collections.synchronizedList(new ArrayList<>());
        // 每个ArrayList 实例都有一个容量 capacity 用于存储元素的数组的大小
        ArrayList<Integer> arrayList = new ArrayList<>();
        List<Integer> list1 = Collections.synchronizedList(new ArrayList<>());

        // Vector 同步的
        Vector<Integer> vector = new Vector<>();

        //Stack继承 Vector 栈是Vector的一个子类，它实现了一个标准的后进先出的堆栈。
        Stack<Integer> stack = new Stack<>();
        /**
         * boolean empty() 测试堆栈是否为空。
         * Object peek( ) 查看堆栈顶部的对象，但不从堆栈中移除它。
         * Object pop( ) 移除堆栈顶部的对象，并作为此函数的值返回该对象。
         * Object push(Object element) 把项压入堆栈顶部。
         * int search(Object element) 返回对象在堆栈中的位置，以 1 为基数。
         */
        // 栈由操作系统自动分配释放 ，用于存放函数的参数值、局部变量等，其操作方式类似于数据结构中的栈

        // 堆由程序员分配释放， 若程序员不释放，程序结束时由OS回收，分配方式倒是类似于链表。参考如下代码

    }

    @Test
    public void set1() {

    }


    @Test
    public void map1() {
        /**
         * HashMap底层实现
         * ①new HashMap();
         * 底层没有创建一个长度为16的数组
         * ②jdk8底层数组为: Node[] ,而非Entry[]   Node
         * ③首次调用put()方法时,才创建了长度为16的数组
         * ④jdk7的底层为: 数组+建表
         *
         * 当数组的某一个索引位置上的元素以链表形式存储的数据个数>8,且当前数组的长度>64时,
         * 此时此索引位置上的所有数据改为使用红黑树存储;
         * 当在树上进行删除操作,使结点数等于6时,又自动转为链表存储
         */
        HashMap<Character,Integer> hm = new HashMap<>(2);

        //TreeMap 底层实现
        /**
         * TreeMap 的实现就是红黑树数据结构，也就说是一棵自平衡的排序二叉树，这样就可以保证当需要快速检索指定节点。
         * 红黑树的插入、删除、遍历时间复杂度都为O(lgN)，所以性能上低于哈希表。但是哈希表无法提供键值对的有序输出，
         * 红黑树因为是排序插入的，可以按照键的值的大小有序输出。
         * 红黑树性质：
         * 性质1：每个节点要么是红色，要么是黑色。
         * 性质2：根节点永远是黑色的。
         * 性质3：所有的叶节点都是空节点（即 null），并且是黑色的。
         * 性质4：每个红色节点的两个子节点都是黑色。（从每个叶子到根的路径上不会有两个连续的红色节点）
         * 性质5：从任一节点到其子树中每个叶子节点的路径都包含相同数量的黑色节点。
         */
        TreeMap<Character,Integer> tm = new TreeMap<>();

        // Hashtable 底层实现，同步的：任何非空（non null）的对象都可以做key或者value
        /**
         * 一、Java中HashMap与Hashtable的区别：
         * HashMap可以接受null键值和值，而Hashtable则不能。
         * Hashtable是线程安全的，通过synchronized实现线程同步。
         * 而HashMap是非线程安全的，但是速度比Hashtable快。
         * 这两个类有许多不同的地方，下面列出了一部分：
         * a) Hashtable 是 JDK 1 遗留下来的类，而 HashMap 是后来增加的。
         * b)Hashtable 是同步(synchronized)的，比较慢，但 HashMap 没有同步策略，所以会更快。
         * c)Hashtable 不允许有个空的 key，但是 HashMap 允许出现一个 null key。
         *
         * 上次讨论了HashMap的结构，原理和实现，本⽂来对Map家族的另外⼀个常⽤集合HashTable进⾏介绍。
         * HashTable和HashMap两种集
         * 合⾮常相似，经常被各种⾯试官问到两者的区别。
         * 对于两者的区别，主要有以下⼏点：
         * HashMap是⾮同步的，没有对读写等操作进⾏锁保护，所以是线程不安全的，在多线程场景下会出现数据不⼀致的问题。⽽HashTable是
         * 同步的，所有的读写等操作都进⾏了锁(synchronized)保护，在多线程环境下没有安全问题。但是锁保护也是有代价的，会对读写的效率
         * 产⽣较⼤影响。
         * HashMap结构中，是允许保存null的，Entry.key和Entry.value均可以为null。但是HashTable中是不允许保存null的。
         * HashMap的迭代器(Iterator)是fail-fast迭代器，但是Hashtable的迭代器(enumerator)不是fail-fast的。如果有其它线程对HashMap进
         * ⾏的添加/删除元素，将会抛出ConcurrentModificationException，但迭代器本⾝的remove⽅法移除元素则不会抛出异常。这条同样也
         * 是Enumeration和Iterator的区别。
         * 链接：https://wenku.baidu.com/view/3378a384b3717fd5360cba1aa8114431b90d8efd.html
         *
         * 原理：HashTable类中，保存实际数据的，依然是Entry对象。其数据结构与HashMap是相同的。
         */
        Hashtable<Integer,Character> ht = new Hashtable<>();


        /**
         * LinkedHashMap
         * 1. LinkedHashMap可以认为是HashMap+LinkedList,
         * 也就是说,它使⽤HashMap操作数据结构,也⽤LinkedList维护插⼊元素的先后顺序.
         * 2. LinkedHashMap的实现思想就是多态,理解LinkedHashMap能帮助我们加深对多态的理
         * 链接：https://wenku.baidu.com/view/b1d0fb4fa75177232f60ddccda38376bae1fe073.html
         */
        LinkedHashMap<Character,Integer> linkedHashMap = new LinkedHashMap<>();
    }


}
