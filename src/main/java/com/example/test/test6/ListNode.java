package com.example.test.test6;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author : baifuquan
 * @date : 2022/6/22 16:03
 * @className : ListNode
 * @description : 单链表类
 * val 数据阈
 * next 指针阈
 **/
@Data
@AllArgsConstructor
public class ListNode {
    int val;
    ListNode next;
    ListNode() {
        System.out.println("ListNode()");
    }
    ListNode(int val) {
        this.val = val;
        System.out.println("ListNode(int val)");
    }

}
