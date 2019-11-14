package _103_binary_tree_zigzag_level_order_traversal;
/*
 * @Author: your name
 *
 * @Date: 2019-11-12 12:25:48
 *
 * @LastEditTime: 2019-11-12 12:36:14
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath:
 * /leetcode/_103_binary_tree_zigzag_level_order_traversal/Solution.java
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

// 思路:
// bfs逐层处理, 考虑遍历方向

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        List<TreeNode> currentLevel = new ArrayList<>();
        currentLevel.add(root);
        boolean changeOrder = false;
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
            if (changeOrder) {
                Collections.reverse(currentVals);
            }
            ret.add(currentVals);
            currentLevel = nextLevel;
            changeOrder = !changeOrder;
        }
        return ret;
    }
}