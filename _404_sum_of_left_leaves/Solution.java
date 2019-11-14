package _404_sum_of_left_leaves;
/*
 * @Author: your name
 *
 * @Date: 2019-11-11 14:28:41
 *
 * @LastEditTime: 2019-11-11 14:48:22
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_404_sum_of_left_leaves/Solution.java
 */

// https://leetcode.com/problems/sum-of-left-leaves/

// 思路:
// 左叶子的和
// 由于无法知道当前节点是否是左叶子, 所有需要向下再找一层
// 用递归的方式处理

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
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left == null) {
            return sumOfLeftLeaves(right);
        }
        if (left.left == null && left.right == null) {
            return left.val + sumOfLeftLeaves(right);
        }
        return sumOfLeftLeaves(left) + sumOfLeftLeaves(right);
    }
}