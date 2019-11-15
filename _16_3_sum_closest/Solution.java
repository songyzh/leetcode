package _16_3_sum_closest;
/*
 * @Author: your name
 *
 * @Date: 2019-11-14 16:43:28
 *
 * @LastEditTime: 2019-11-14 16:58:15
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_16_3_sum_closest/Solution.java
 */

// https://leetcode.com/problems/3sum-closest/

import java.util.Arrays;

// 思路:
// 先排序, 然后遍历所有可能性

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        Integer ret = null;
        for (int i = 0; i < nums.length; ++i) {
            int curr = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = curr + nums[left] + nums[right];
                if (sum == target) {
                    return target;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
                if (ret == null) {
                    ret = sum;
                } else {
                    ret = Math.abs(ret - target) < Math.abs(sum - target) ? ret : sum;
                }

            }
        }
        return ret;
    }
}