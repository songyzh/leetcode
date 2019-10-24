package _110_balanced_binary_tree;
/*
 * @Author: your name
 * @Date: 2019-10-23 21:40:59
 * @LastEditTime: 2019-10-23 21:48:27
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/_110_balanced_binary_tree/Solution.java
 */

// https://leetcode.com/problems/balanced-binary-tree/

// 思路:
// 如果一棵树是平衡二叉树, 则左右子树的高度差不超过1, 且左右子树也分别是平衡二叉树

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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }
}