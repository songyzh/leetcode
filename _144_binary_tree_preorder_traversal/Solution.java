package _144_binary_tree_preorder_traversal;
/*
 * @Description:
 *
 * @Author: syzh
 *
 * @Date: 2019-11-20 12:47:17
 *
 * @LastEditors: syzh
 *
 * @LastEditTime: 2019-11-20 12:55:31
 *
 * @FilePath: /leetcode/_144_binary_tree_preorder_traversal/Solution.java
 *
 * @Github: https://github.com/songyzh
 */

import java.util.ArrayList;

// https://leetcode.com/problems/binary-tree-preorder-traversal/

import java.util.List;
import java.util.Stack;

// 思路:
// 尝试递归求解

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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                ret.add(node.val);
                if (node.right != null) {
                    stack.add(node.right);
                }
                if (node.left != null) {
                    stack.add(node.left);
                }
            }
        }
        return ret;
    }
}