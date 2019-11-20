package _147_insertion_sort_list;
/*
 * @Description:
 *
 * @Author: syzh
 *
 * @Date: 2019-11-20 14:24:46
 *
 * @LastEditors: syzh
 *
 * @LastEditTime: 2019-11-20 15:46:48
 *
 * @FilePath: /leetcode/_147_insertion_sort_list/Solution.java
 *
 * @Github: https://github.com/songyzh
 */

// https://leetcode.com/problems/insertion-sort-list/

// 思路:
// 链表插入排序

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
    public ListNode insertionSortList(ListNode head) {
        ListNode ret = new ListNode(Integer.MIN_VALUE);
        ListNode headNew = ret;
        while (head != null) {
            ListNode prev = null;
            while (headNew != null) {
                if (head.val >= headNew.val) {
                    prev = headNew;
                }
                headNew = headNew.next;
            }
            ListNode nextHead = head.next;
            head.next = prev.next;
            prev.next = head;
            head = nextHead;
            headNew = ret;
        }
        return ret.next;
    }
}