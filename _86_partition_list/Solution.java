package _86_partition_list;
/*
 * @Description:
 *
 * @Author: syzh
 *
 * @Date: 2019-11-19 12:30:50
 *
 * @LastEditors: syzh
 *
 * @LastEditTime: 2019-11-19 12:45:13
 *
 * @FilePath: /leetcode/_86_partition_list/Solution.java
 *
 * @Github: https://github.com/songyzh
 */

// https://leetcode.com/problems/partition-list/

// 思路:
// 维护两条链, 之后合并

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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode head1 = dummy1;
        ListNode head2 = dummy2;
        while (head != null) {
            if (head.val < x) {
                dummy1.next = head;
                dummy1 = dummy1.next;
            } else {
                dummy2.next = head;
                dummy2 = dummy2.next;
            }
            head = head.next;
        }
        dummy2.next = null;
        dummy1.next = head2.next;
        return head1.next;
    }
}