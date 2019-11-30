package _153_find_minimum_in_rotated_sorted_array;
/*
 * @Description:
 *
 * @Author: syzh
 *
 * @Date: 2019-11-20 22:21:30
 *
 * @LastEditors: syzh
 *
 * @LastEditTime: 2019-11-21 09:52:01
 *
 * @FilePath: /leetcode/_153_find_minimum_in_rotated_sorted_array/Solution.java
 *
 * @Github: https://github.com/songyzh
 */

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

// 思路:
// 二分查找

class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}