package _19_remove_nth_node_from_end_of_list;
/*
 * @Author: your name
 *
 * @Date: 2019-11-14 19:06:34
 *
 * @LastEditTime: 2019-11-14 19:20:46
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_19_remove_nth_node_from_end_of_list/Solution.java
 */

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/

// 思路:
// 可以保存在数组中
// 注意最后加null

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> lst = new ArrayList<>();
        while (head != null) {
            lst.add(head);
            head = head.next;
        }
        if (lst.size() == 1) {
            return null;
        }
        if (n == lst.size()) {
            return lst.get(1);
        }
        lst.add(null);
        int index = lst.size() - n - 2;
        lst.get(index).next = lst.get(lst.size() - n);
        return lst.get(0);
    }
}