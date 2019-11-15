package _34_find_first_and_last_position_of_element_in_sorted_array;
/*
 * @Author: your name
 *
 * @Date: 2019-11-15 14:29:11
 *
 * @LastEditTime: 2019-11-15 15:02:56
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath:
 * /leetcode/_34_find_first_and_last_position_of_element_in_sorted_array/
 * Solution.java
 */

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

// 思路:
// 先用二分法确定范围
// 然后分别找到起点和终点

class Solution {
    int low = -1;
    int high = -1;
    int[] nums;
    int target;

    public int[] searchRange(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        helper(0, nums.length - 1);
        return new int[] { low, high };
    }

    void helper(int start, int end) {
        if (start > end) {
            return;
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] > target) {
            helper(start, mid - 1);
        } else if (nums[mid] < target) {
            helper(mid + 1, end);
        } else {
            low = low == -1 ? mid : low;
            high = high == -1 ? mid : high;
            low = low < mid ? low : mid;
            helper(start, mid - 1);
            high = high > mid ? high : mid;
            helper(mid + 1, end);
        }
    }

}