package _107_binary_tree_level_order_traversal_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
 * @Author: your name
 * @Date: 2019-10-23 21:07:56
 * @LastEditTime: 2019-10-23 21:21:05
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/_107_binary_tree_level_order_traversal_ii/Solution.java
 */
// https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

// 思路:
// 对二叉树进行广度优先搜索, 然后翻转

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }

        List<TreeNode> currentLevel = Arrays.asList(root);
        while (!currentLevel.isEmpty()) {
            List<Integer> curerntVals = new ArrayList<>();
            ret.add(curerntVals);
            List<TreeNode> nextLevel = new ArrayList<>();

            for (TreeNode currentNode : currentLevel) {
                curerntVals.add(currentNode.val);
                TreeNode left = currentNode.left;
                TreeNode right = currentNode.right;
                if (left != null) {
                    nextLevel.add(left);
                }
                if (right != null) {
                    nextLevel.add(right);
                }
            }
            currentLevel = nextLevel;
        }

        Collections.reverse(ret);
        return ret;
    }
}