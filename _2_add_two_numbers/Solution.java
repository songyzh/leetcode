package _2_add_two_numbers;
/*
 * @Author: your name
 *
 * @Date: 2019-11-14 12:57:00
 *
 * @LastEditTime: 2019-11-14 13:25:13
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_2_add_two_numbers/Solution.java
 */

// https://leetcode.com/problems/add-two-numbers/

// 思路:
// 同时遍历两链表
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int i1 = 0;
            if (l1 != null) {
                i1 = l1.val;
                l1 = l1.next;
            }
            int i2 = 0;
            if (l2 != null) {
                i2 = l2.val;
                l2 = l2.next;
            }
            int sum = i1 + i2 + carry;
            int curr = sum % 10;
            carry = sum / 10;
            head.next = new ListNode(curr);
            head = head.next;
        }
        if (carry == 1) {
            head.next = new ListNode(1);
        }
        return dummy.next;
    }
}