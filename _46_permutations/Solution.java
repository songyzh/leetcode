package _46_permutations;
/*
 * @Author: your name
 * @Date: 2019-11-16 11:47:03
 * @LastEditTime: 2019-11-16 15:00:00
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/_46_permutations/Solution.java
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/permutations/

// 思路:
// 回溯

class Solution {
    List<List<Integer>> ret = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        helper(new ArrayList<>(), new boolean[nums.length]);
        return ret;
    }

    void helper(List<Integer> current, boolean[] used) {
        if (current.size() == nums.length) {
            ret.add(current);
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (!used[i]) {
                List<Integer> newCurrent = new ArrayList<>(current);
                newCurrent.add(nums[i]);
                boolean[] newUsed = Arrays.copyOf(used, used.length);
                newUsed[i] = true;
                helper(newCurrent, newUsed);
            }
        }
    }
}