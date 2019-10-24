package _101_symmetric_tree;
/*
 * @Author: your name
 * @Date: 2019-10-23 19:26:59
 * @LastEditTime: 2019-10-23 19:29:24
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/_101_symmetric_tree/Solution.java
 */

// https://leetcode.com/problems/symmetric-tree/

// 思路:
// 是对称树, 则
// 左子树和右子树互为镜像

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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
    }
}