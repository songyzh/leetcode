package _90_subsets_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @Description:
 *
 * @Author: syzh
 *
 * @Date: 2019-11-19 17:06:55
 *
 * @LastEditors: syzh
 *
 * @LastEditTime: 2019-11-19 17:13:23
 *
 * @FilePath: /leetcode/_90_subsets_ii/Solution.java
 *
 * @Github: https://github.com/songyzh
 */
// https://leetcode.com/problems/subsets-ii/

// 思路:
// 回溯, 注意去重

class Solution {
    List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<>());
        return ret;
    }

    void helper(int[] nums, int start, List<Integer> current) {
        ret.add(current);
        for (int i = start; i < nums.length; ++i) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            List<Integer> currentNew = new ArrayList<>(current);
            currentNew.add(nums[i]);
            helper(nums, i + 1, currentNew);
        }
    }
}