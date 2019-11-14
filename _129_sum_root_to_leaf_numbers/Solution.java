package _129_sum_root_to_leaf_numbers;

/*
 * @Author: your name
 * @Date: 2019-11-13 21:20:41
 * @LastEditTime: 2019-11-13 21:34:35
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/_129_sum_root_to_leaf_numbers/Solution.java
 */
// https://leetcode.com/problems/sum-root-to-leaf-numbers/

// 思路:
// 回溯

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
    int ret = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(0, root);
        return ret;
    }

    void helper(int current, TreeNode root) {
        if (root.left == null && root.right == null) {
            ret += current * 10 + root.val;
            return;
        }
        if (root.left != null) {
            helper(current * 10 + root.val, root.left);
        }
        if (root.right != null) {
            helper(current * 10 + root.val, root.right);
        }
    }
}