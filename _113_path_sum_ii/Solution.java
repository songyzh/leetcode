package _113_path_sum_ii;
/*
 * @Author: your name
 *
 * @Date: 2019-11-12 20:27:22
 *
 * @LastEditTime: 2019-11-12 20:46:31
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_113_path_sum_ii/Solution.java
 */

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/path-sum-ii/

// 思路:
// 回溯法求解

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
    List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        helper(new ArrayList<>(), root, sum);
        return ret;
    }

    void helper(List<Integer> current, TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        if (root.val == sum && root.left == null && root.right == null) {
            current.add(root.val);
            ret.add(current);
            return;
        }
        List<Integer> next1 = new ArrayList<>(current);
        next1.add(root.val);
        helper(next1, root.left, sum - root.val);
        List<Integer> next2 = new ArrayList<>(current);
        next2.add(root.val);
        helper(next2, root.right, sum - root.val);
    }
}