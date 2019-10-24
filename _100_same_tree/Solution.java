package _100_same_tree;
/*
 * @Author: your name
 * @Date: 2019-10-23 19:05:32
 * @LastEditTime: 2019-10-23 19:29:13
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/_100_same_tree/Solution.java
 */

// https://leetcode.com/problems/same-tree/

// 思路:
// 两棵树相等, 则
// 当前节点值相等
// 二者左子树相等
// 二者右子树相等
// 先写基本的相等条件

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}