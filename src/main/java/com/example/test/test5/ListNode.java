package com.example.test.test5;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author : baifuquan
 * @date : 2022/6/22 10:09
 * @className : Node
 * @description : Node
 **/

@Data
@AllArgsConstructor
public class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}
