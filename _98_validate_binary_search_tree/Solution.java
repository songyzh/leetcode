package _98_validate_binary_search_tree;
/*
 * @Author: your name
 *
 * @Date: 2019-11-11 17:38:22
 *
 * @LastEditTime: 2019-11-12 10:34:49
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_98_validate_binary_search_tree/Solution.java
 */

// https://leetcode.com/problems/validate-binary-search-tree/

// 思路:
// 递归, 并注意比较和根节点的大小

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
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        // root的值, 在min和max中间, 且左子树和右子树满足条件
        return (min == null || root.val > min) && (max == null || root.val < max) && helper(root.left, min, root.val)
                && helper(root.right, root.val, max);
    }
}