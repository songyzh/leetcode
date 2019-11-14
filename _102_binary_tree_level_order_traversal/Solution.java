package _102_binary_tree_level_order_traversal;

import java.util.ArrayList;
import java.util.List;

/*
 * @Author: your name
 *
 * @Date: 2019-11-12 11:21:44
 *
 * @LastEditTime: 2019-11-12 12:24:01
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_102_binary_tree_level_order_traversal/Solution.java
 */
// https://leetcode.com/problems/binary-tree-level-order-traversal/

// 思路:
// bfs逐层处理

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        List<TreeNode> currentLevel = new ArrayList<>();
        currentLevel.add(root);
        while (!currentLevel.isEmpty()) {
            List<Integer> currentVals = new ArrayList<>();
            List<TreeNode> nextLevel = new ArrayList<>();
            for (TreeNode node : currentLevel) {
                currentVals.add(node.val);
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            ret.add(currentVals);
            currentLevel = nextLevel;
        }
        return ret;
    }
}