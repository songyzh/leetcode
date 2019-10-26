package _141_linked_list_cycle;
/*
 * @Author: your name
 *
 * @Date: 2019-10-26 13:11:58
 *
 * @LastEditTime: 2019-10-26 13:20:46
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_141_linked_list_cycle/Solution.java
 */

// https://leetcode.com/problems/linked-list-cycle/

// 思路:
// 常规解法: 使用快慢双指针, 如果相遇, 则有环

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
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode headFast = head.next;
        while (head != null && headFast != null && head != headFast) {
            head = head.next;
            if (headFast.next == null) {
                return false;
            }
            headFast = headFast.next.next;
        }
        return head == headFast;
    }
}