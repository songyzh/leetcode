package __287_find_the_duplicate_number;
/*
 * @Author: your name
 *
 * @Date: 2019-11-15 11:27:26
 *
 * @LastEditTime: 2019-11-15 12:24:21
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_287_find_the_duplicate_number/Solution.java
 */

import java.util.Arrays;

// https://leetcode.com/problems/find-the-duplicate-number/

// 思路:
// 不能修改数组, 所以不能排序

class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return 0;
    }
}