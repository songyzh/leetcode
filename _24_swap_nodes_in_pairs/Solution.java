package _24_swap_nodes_in_pairs;
/*
 * @Author: your name
 *
 * @Date: 2019-11-14 22:02:43
 *
 * @LastEditTime: 2019-11-14 22:08:56
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_24_swap_nodes_in_pairs/Solution.java
 */

// https://leetcode.com/problems/swap-nodes-in-pairs/

// 思路:
// 递归

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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextHead = head.next.next;
        ListNode dummy = new ListNode(0);
        dummy.next = head.next;
        head.next.next = head;
        head.next = swapPairs(nextHead);
        return dummy.next;
    }
}