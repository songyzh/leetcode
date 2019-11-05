package _257_binary_tree_paths;
/*
 * @Author: your name
 *
 * @Date: 2019-11-04 14:10:35
 *
 * @LastEditTime: 2019-11-04 15:52:04
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_257_binary_tree_paths/Solution.java
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/binary-tree-paths/

// 思路:
// 用递归的思想, 找到父子节点结果之间的关系

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
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        if (root.left == null && root.right == null) {
            return Arrays.asList(String.valueOf(root.val));
        }
        List<String> ret = new ArrayList<>();
        List<String> left = binaryTreePaths(root.left);
        for (String l : left) {
            ret.add(root.val + "->" + l);
        }
        List<String> right = binaryTreePaths(root.right);
        for (String r : right) {
            ret.add(root.val + "->" + r);
        }
        return ret;
    }
}