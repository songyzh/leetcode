package __143_reorder_list;
/*
 * @Description:
 *
 * @Author: syzh
 *
 * @Date: 2019-11-20 12:14:06
 *
 * @LastEditors: syzh
 *
 * @LastEditTime: 2019-11-20 12:46:31
 *
 * @FilePath: /leetcode/_143_reorder_list/Solution.java
 *
 * @Github: https://github.com/songyzh
 */

// https://leetcode.com/problems/reorder-list/

// 思路:
// 递归, 速度较慢
// 翻转右半部分

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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

    }

}