package _78_subsets;
/*
 * @Description:
 *
 * @Author: syzh
 *
 * @Date: 2019-11-18 14:00:21
 *
 * @LastEditors: syzh
 *
 * @LastEditTime: 2019-11-18 14:17:20
 *
 * @FilePath: /leetcode/_78_subsets/Solution.java
 *
 * @Github: https://github.com/songyzh
 */

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/subsets/

// 思路:
// 1. 回溯
// 2. 递归
// f(n) = f(n - 1) + g(f(n - 1)), 注意deepcopy的问题

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return subsets(nums, nums.length - 1);
    }

    List<List<Integer>> subsets(int[] nums, int end) {
        List<List<Integer>> ret = new ArrayList<>();
        if (end == -1) {
            ret.add(new ArrayList<>());
            return ret;
        }
        List<List<Integer>> prev = subsets(nums, end - 1);
        for (List<Integer> p : prev) {
            p.add(nums[end]);
        }
        prev.addAll(subsets(nums, end - 1));
        return prev;
    }
}