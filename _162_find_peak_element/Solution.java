package _162_find_peak_element;
/*
 * @Description:
 *
 * @Author: syzh
 *
 * @Date: 2019-11-21 10:12:02
 *
 * @LastEditors: syzh
 *
 * @LastEditTime: 2019-11-21 11:25:13
 *
 * @FilePath: /leetcode/_162_find_peak_element/Solution.java
 *
 * @Github: https://github.com/songyzh
 */

// https://leetcode.com/problems/find-peak-element/

// 思路:
// 要求时间复杂度logn, 二分查找

class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            int left = mid == 0 ? Integer.MIN_VALUE : nums[mid - 1];
            int right = mid == nums.length - 1 ? Integer.MIN_VALUE : nums[mid + 1];
            if (nums[mid] >= left && nums[mid] >= right) {
                return mid;
            }
            if (nums[mid] >= right) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}