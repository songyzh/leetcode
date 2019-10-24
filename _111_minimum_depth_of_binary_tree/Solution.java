package _111_minimum_depth_of_binary_tree;
/*
 * @Author: your name
 * @Date: 2019-10-24 08:37:09
 * @LastEditTime: 2019-10-24 09:00:50
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/_111_minimum_depth_of_binary_tree/Solution.java
 */

// https://leetcode.com/problems/minimum-depth-of-binary-tree/

// 思路:
// 最小深度, 为左子树和右子树中, 深度较小的深度, +1
// 注意: [1, 2, null]的最小深度为2, 要提前处理这种情况

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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left == null && right == null) {
            return 1;
        }
        if (left == null) {
            return minDepth(right) + 1;
        }
        if (right == null) {
            return minDepth(left) + 1;
        }
        return Math.min(minDepth(left), minDepth(right)) + 1;
    }
}