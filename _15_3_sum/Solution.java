package _15_3_sum;
/*
 * @Author: your name
 *
 * @Date: 2019-11-14 16:17:25
 *
 * @LastEditTime: 2019-11-14 16:34:23
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_15_3_sum/Solution.java
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/3sum/

// 思路:
// 由于不能有重复的, 故可先排序进行简化

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int curr = nums[i];
            int sum = -curr;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (left > i + 1 && nums[left - 1] == nums[left]) {
                    left++;
                    continue;
                }
                if (right < nums.length - 1 && nums[right + 1] == nums[right]) {
                    right--;
                    continue;
                }
                int total = nums[left] + nums[right];
                if (total > sum) {
                    right--;
                } else if (total < sum) {
                    left++;
                } else {
                    ret.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                }
            }
        }
        return ret;
    }
}