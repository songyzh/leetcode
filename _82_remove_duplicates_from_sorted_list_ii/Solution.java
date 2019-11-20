package _82_remove_duplicates_from_sorted_list_ii;
/*
 * @Description:
 *
 * @Author: syzh
 *
 * @Date: 2019-11-18 22:08:11
 *
 * @LastEditors: syzh
 *
 * @LastEditTime: 2019-11-19 12:27:29
 *
 * @FilePath: /leetcode/_82_remove_duplicates_from_sorted_list_ii/Solution.java
 *
 * @Github: https://github.com/songyzh
 */

// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

// 思路:
// 使用dummy节点, 不断加到dummy上

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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode ret = dummy;
        while (head != null && head.next != null) {
            if (head.val != head.next.val) {
                dummy.next = head;
                dummy = dummy.next;
                head = head.next;
            } else {
                int current = head.val;
                while (head != null && head.val == current) {
                    head = head.next;
                }
            }
        }
        dummy.next = head;
        return ret.next;
    }
}