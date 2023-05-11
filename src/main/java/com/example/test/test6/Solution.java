package com.example.test.test6;


/**
 * @author : baifuquan
 * @date : 2022/6/22 15:57
 * @className : Solution
 * @description : Solution
 **/
public class Solution {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode node = mergeLists(listNode,listNode2);
        System.out.println(node.toString());
    }
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) {
            return null;
        }
        for (int i = 0; i < n - 1; ++i) {
            lists[i + 1] = mergeLists(lists[i], lists[i + 1]);
        }
        return lists[n - 1];
    }

    /**
     * 1.两个有序的单链表 ；合并成一个有序的单链表
     * @param l1
     * @param l2
     * @return
     */
    private static ListNode mergeLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
