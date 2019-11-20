package _142_linked_list_cycle_ii;
/*
 * @Description:
 *
 * @Author: syzh
 *
 * @Date: 2019-11-19 21:34:30
 *
 * @LastEditors: syzh
 *
 * @LastEditTime: 2019-11-20 12:13:03
 *
 * @FilePath: /leetcode/_142_linked_list_cycle_ii/Solution.java
 *
 * @Github: https://github.com/songyzh
 */

// https://leetcode.com/problems/linked-list-cycle-ii/

// 思路:
// 找到环的长度, 然后设置快慢指针, 快指针先走环的长度c. 慢指针距离入口a, 快指针离开入口b, 则a + b = c
// 快指针和慢指针到入口的距离均为a, 则走a步后, 相遇在入口

/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        do {
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != null && fast != null && fast.next != null && slow != fast);
        if (slow == null || fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}