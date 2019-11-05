package _234_palindrome_linked_list;
/*
 * @Author: your name
 *
 * @Date: 2019-11-03 12:05:40
 *
 * @LastEditTime: 2019-11-04 10:16:05
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_234_palindrome_linked_list/Solution.java
 */

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/palindrome-linked-list/

// 思路:
// 1. 把数字存在list中, 再进行检查
// 2. 快慢指针, 找到中点, 然后翻转后面的部分, 与前一部分进行比较
// 注意: 比较两个数字的时候, 如果是integer, 需要使用equals

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
    public boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<>();
        while (head != null) {
            vals.add(head.val);
            head = head.next;
        }
        int i = 0;
        int j = vals.size() - 1;
        while (i < j) {
            if (!vals.get(i++).equals(vals.get(j--))) {
                return false;
            }
        }
        return true;
    }
}