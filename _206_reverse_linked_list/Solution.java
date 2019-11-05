package _206_reverse_linked_list;
/*
 * @Author: your name
 * @Date: 2019-11-03 09:47:40
 * @LastEditTime: 2019-11-03 10:03:59
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/_206_reverse_linked_list/Solution.java
 */

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/reverse-linked-list/

// 思路:
// 把节点依次存起来, 然后从后向前拼接
// 注意: 最终节点需要以null结尾

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        ListNode dummy = new ListNode(0);
        ListNode ret = dummy;
        for (int i = list.size() - 1; i >= 0; --i) {
            dummy.next = list.get(i);
            dummy = dummy.next;
        }
        dummy.next = null;
        return ret.next;
    }
}