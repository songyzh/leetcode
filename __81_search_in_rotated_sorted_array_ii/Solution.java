package __81_search_in_rotated_sorted_array_ii;
/*
 * @Description:
 *
 * @Author: syzh
 *
 * @Date: 2019-11-18 21:30:22
 *
 * @LastEditors: syzh
 *
 * @LastEditTime: 2019-11-18 22:07:23
 *
 * @FilePath: /leetcode/_81_search_in_rotated_sorted_array_ii/Solution.java
 *
 * @Github: https://github.com/songyzh
 */

import java.util.Arrays;

// https://leetcode.com/problems/search-in-rotated-sorted-array-ii/

// 思路:
// 先二分查找

class Solution {
    public boolean search(int[] nums, int target) {
        return helper(nums, 0, nums.length - 1, target);
    }

    boolean helper(int[] nums, int start, int end, int target) {
        if (start > end) {
            return false;
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            return true;
        }
        if (nums[start] == nums[end] && nums[start] == nums[mid]) {
            return helper(nums, start + 1, end - 1, target);
        }
        if (nums[start] < nums[end]) {
            return Arrays.binarySearch(nums, start, end + 1, target) >= 0;
        }
        return helper(nums, start, mid - 1, target) || helper(nums, mid + 1, end, target);
    }
}