package __95_unique_binary_search_trees_ii;
/*
 * @Author: your name
 *
 * @Date: 2019-11-11 16:37:38
 *
 * @LastEditTime: 2019-11-14 12:59:31
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_95_unique_binary_search_trees_ii/Solution.java
 */

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/unique-binary-search-trees-ii/

// 思路:
// 以各个元素为根节点, 生成二叉搜索树
// 使用递归处理

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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return helper(1, n);
    }

    List<TreeNode> helper(int start, int end) {
        List<TreeNode> ret = new ArrayList<>();
        if (start > end) {
            ret.add(null);
            return ret;
        }
        if (start == end) {
            ret.add(new TreeNode(start));
            return ret;
        }
        for (int i = start; i <= end; ++i) {
            List<TreeNode> lefts = helper(start, i - 1);
            List<TreeNode> rights = helper(i + 1, end);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    ret.add(root);
                }
            }
        }
        return ret;
    }
}