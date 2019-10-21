package _21_merge_two_sorted_lists;

/*
 * @Author: your name
 * @Date: 2019-10-20 23:08:26
 * @LastEditTime: 2019-10-20 23:16:15
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/_21_merge_two_sorted_lists/Solution.java
 */
// https://leetcode.com/problems/merge-two-sorted-lists/

// 思路:
// 创建dummy节点
// 比较两个链表, 在dummy后添加较小的那个, 同时更新处理过的链表
// 需要实时检查链表是否为null

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode ret = dummy;
        while (l1 != null && l2 != null) {
            int val1 = l1.val;
            int val2 = l2.val;
            if (val1 < val2) {
                dummy.next = new ListNode(val1);
                l1 = l1.next;
            } else {
                dummy.next = new ListNode(val2);
                l2 = l2.next;
            }
            dummy = dummy.next;
        }
        if (l1 != null) {
            dummy.next = l1;
        } else {
            dummy.next = l2;
        }
        return ret.next;
    }
}