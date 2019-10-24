package _104_maximum_depth_of_binary_tree;
/*
 * @Author: your name
 * @Date: 2019-10-23 21:02:26
 * @LastEditTime: 2019-10-23 21:04:13
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/_104_maximum_depth_of_binary_tree/Solution.java
 */

// https://leetcode.com/problems/maximum-depth-of-binary-tree/

// 思路:
// 最大深度, 等于左子树和右子树深度较大的那个, +1

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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}