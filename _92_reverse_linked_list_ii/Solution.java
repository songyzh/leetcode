package _92_reverse_linked_list_ii;
/*
 * @Author: your name
 *
 * @Date: 2019-11-11 14:53:26
 *
 * @LastEditTime: 2019-11-11 15:12:50
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_92_reverse_linked_list_ii/Solution.java
 */

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/reverse-linked-list-ii/

// 思路:
// 把要翻转的节点存储起来

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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        int current = 1;
        ListNode before = null;
        ListNode after = null;
        ListNode headCopy = head;
        List<ListNode> lst = new ArrayList<>();
        while (headCopy != null) {
            if (current == m - 1) {
                before = headCopy;
            }
            if (current == n + 1) {
                after = headCopy;
            }
            if (m <= current && current <= n) {
                lst.add(headCopy);
            }
            headCopy = headCopy.next;
            current++;
        }
        for (int i = 1; i < lst.size(); ++i) {
            lst.get(i).next = lst.get(i - 1);
        }
        ListNode ret;
        if (before != null) {
            before.next = lst.get(lst.size() - 1);
            ret = head;
        } else {
            ret = lst.get(lst.size() - 1);
        }
        if (after != null) {
            lst.get(0).next = after;
        } else {
            lst.get(0).next = null;
        }
        return ret;
    }
}