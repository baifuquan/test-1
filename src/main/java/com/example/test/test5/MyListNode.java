package com.example.test.test5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : baifuquan
 * @date : 2022/6/22 10:11
 * @className : Test3
 * @description : Test3
 **/
public class MyListNode {

    public static void main(String[] args) {


        ListNode list1 = createList();
//        List<Node> list2 = createList2();
        System.out.println(list1);
//        System.out.println(list2);
    }

    //单向循环链表
    public static ListNode createList() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        return node3;
    }

    //单向循环链表
    public static List<ListNode> createList2() {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        List<ListNode> list = new LinkedList<>();
        list.add(node1);
        list.add(node2);
        list.add(node3);
        return list;
    }


}
