/*
 * @Author: your name
 * @Date: 2019-10-23 18:29:14
 * @LastEditTime: 2019-10-23 18:42:34
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/_83_remove_duplicates_from_sorted_list/Solution.java
 */
// https://leetcode.com/problems/remove-duplicates-from-sorted-list/

// 思路:
// 记录前一个节点的值, 如果当前节点的值相同, 则前一节点的next为后一节点

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode ret = head;
        while (head != null) {
            ListNode next = head.next;
            if (next == null) {
                return ret;
            }
            if (head.val == next.val) {
                head.next = next.next;
            } else {
                head = next;
            }
        }
        return ret;
    }
}