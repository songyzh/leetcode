package _40_combination_sum_ii;
/*
 * @Author: your name
 *
 * @Date: 2019-11-15 17:01:44
 *
 * @LastEditTime: 2019-11-15 17:23:34
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_40_combination_sum_ii/Solution.java
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/combination-sum-ii/

// 思路:
// 与上一题类似, 需要注意, 在某个位置上放置了某数字后, 此位置上不能再放置同样的数

class Solution {
    List<List<Integer>> ret = new ArrayList<>();
    int[] candidates;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        helper(new ArrayList<>(), 0, target);
        return ret;
    }

    void helper(List<Integer> current, int start, int remain) {
        if (remain == 0) {
            ret.add(current);
            return;
        }
        for (int i = start; i < candidates.length; ++i) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            int num = candidates[i];
            if (num <= remain) {
                List<Integer> next = new ArrayList<>(current);
                next.add(num);
                helper(next, i + 1, remain - num);
            }
        }
    }
}