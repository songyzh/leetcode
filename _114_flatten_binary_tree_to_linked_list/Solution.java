package _114_flatten_binary_tree_to_linked_list;
/*
 * @Author: your name
 *
 * @Date: 2019-11-12 20:49:48
 *
 * @LastEditTime: 2019-11-12 21:32:28
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_114_flatten_binary_tree_to_linked_list/Solution.java
 */

// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

// 思路:
// 递归求解
// 不要忘记把root.left置为null

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        flatten(left);
        flatten(right);
        if (left == null) {
            return;
        }
        root.left = null;
        root.right = left;
        TreeNode prev = left;
        while (left != null) {
            prev = left;
            left = left.right;
        }
        prev.right = right;
    }
}