package _226_invert_binary_tree;
/*
 * @Author: your name
 *
 * @Date: 2019-11-03 11:35:11
 *
 * @LastEditTime: 2019-11-03 11:55:43
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_226_invert_binary_tree/Solution.java
 */

// https://leetcode.com/problems/invert-binary-tree/

// 思路:
// 递归处理

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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}