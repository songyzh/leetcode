package _47_permutations_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @Author: your name
 *
 * @Date: 2019-11-16 15:15:28
 *
 * @LastEditTime: 2019-11-16 15:59:49
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_47_permutations_ii/Solution.java
 */
// https://leetcode.com/problems/permutations-ii/

// 思路:
// 回溯
// 注意排重, 先排序

class Solution {
    List<List<Integer>> ret = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
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
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            List<Integer> currentNew = new ArrayList<>(current);
            currentNew.add(nums[i]);
            boolean[] usedNew = Arrays.copyOf(used, used.length);
            usedNew[i] = true;
            helper(currentNew, usedNew);
        }
    }

}