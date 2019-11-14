package _303_range_sum_query_immutable;
/*
 * @Author: your name
 * @Date: 2019-11-07 16:29:51
 * @LastEditTime: 2019-11-07 16:45:34
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/_303_range_sum_query_immutable/Solution.java
 */

// https://leetcode.com/problems/range-sum-query-immutable/

// 思路:
// dp的思想, 存储截止各个位置的和

class NumArray {

    int[] sums;

    public NumArray(int[] nums) {
        sums = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            if (i == 0) {
                sums[i] = nums[0];
            } else {
                sums[i] = sums[i - 1] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return sums[j];
        }
        return sums[j] - sums[i - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such: NumArray obj =
 * new NumArray(nums); int param_1 = obj.sumRange(i,j);
 */