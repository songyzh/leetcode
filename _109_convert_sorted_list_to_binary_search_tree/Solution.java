package _109_convert_sorted_list_to_binary_search_tree;
/*
 * @Author: your name
 * @Date: 2019-11-12 18:12:27
 * @LastEditTime: 2019-11-12 18:35:24
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/_109_convert_sorted_list_to_binary_search_tree/Solution.java
 */

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/

// 思路:
// 递归求解

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

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    List<Integer> lst = new ArrayList<>();

    public TreeNode sortedListToBST(ListNode head) {
        while (head != null) {
            lst.add(head.val);
            head = head.next;
        }
        return helper(0, lst.size() - 1);
    }

    TreeNode helper(int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(lst.get(start));
        }
        int mid = start + (end - start) / 2;
        TreeNode ret = new TreeNode(lst.get(mid));
        ret.left = helper(start, mid - 1);
        ret.right = helper(mid + 1, end);
        return ret;
    }
}