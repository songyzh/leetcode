package _39_combination_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @Author: your name
 *
 * @Date: 2019-11-15 16:32:05
 *
 * @LastEditTime: 2019-11-15 17:06:41
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_39_combination_sum/Solution.java
 */
// https://leetcode.com/problems/combination-sum/

// 思路:
// 回溯
// 由于不能重复, 所以先排序

class Solution {
    List<List<Integer>> ret = new ArrayList<>();
    int[] candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            int num = candidates[i];
            if (num <= remain) {
                List<Integer> next = new ArrayList<>(current);
                next.add(num);
                helper(next, i, remain - num);
            }
        }
    }
}