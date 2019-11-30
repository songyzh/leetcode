package _199_binary_tree_right_side_view;
/*
 * @Description:
 *
 * @Author: syzh
 *
 * @Date: 2019-11-21 18:35:54
 *
 * @LastEditors: syzh
 *
 * @LastEditTime: 2019-11-21 19:02:48
 *
 * @FilePath: /leetcode/_199_binary_tree_right_side_view/Solution.java
 *
 * @Github: https://github.com/songyzh
 */

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-right-side-view/

// 思路:
// bfs

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        List<TreeNode> prevLevel = new ArrayList<>();
        prevLevel.add(root);
        while (!prevLevel.isEmpty()) {
            ret.add(prevLevel.get(prevLevel.size() - 1).val);
            List<TreeNode> currentLevel = new ArrayList<>();
            for (TreeNode node : prevLevel) {
                if (node.left != null) {
                    currentLevel.add(node.left);
                }
                if (node.right != null) {
                    currentLevel.add(node.right);
                }
            }
            prevLevel = currentLevel;
        }
        return ret;
    }
}