package _61_rotate_list;
/*
 * @Description:
 *
 * @Author: syzh
 *
 * @Date: 2019-11-17 11:14:04
 *
 * @LastEditors: syzh
 *
 * @LastEditTime: 2019-11-17 11:28:04
 *
 * @FilePath: /leetcode/_61_rotate_list/Solution.java
 *
 * @Github: https://github.com/songyzh
 */

// https://leetcode.com/problems/rotate-list/

// 思路:
// 注意处理头尾的next

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
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) {
            return head;
        }
        int len = 0;
        ListNode head1 = head;
        ListNode last = null;
        while (head1 != null) {
            len++;
            last = head1;
            head1 = head1.next;
        }
        k %= len;
        if (k == 0) {
            return head;
        }
        head1 = head;
        for (int i = 0; i < len - k - 1; ++i) {
            head1 = head1.next;
        }
        ListNode headNew = head1.next;
        last.next = head;
        head1.next = null;
        return headNew;
    }
}