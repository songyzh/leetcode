package _75_sort_colors;
/*
 * @Description:
 *
 * @Author: syzh
 *
 * @Date: 2019-11-18 11:39:03
 *
 * @LastEditors: syzh
 *
 * @LastEditTime: 2019-11-18 12:00:02
 *
 * @FilePath: /leetcode/_75_sort_colors/Solution.java
 *
 * @Github: https://github.com/songyzh
 */

// https://leetcode.com/problems/sort-colors/

// 思路:
// 两个指针, 来分隔0, 1, 2

class Solution {
    int[] nums;

    public void sortColors(int[] nums) {
        this.nums = nums;
        int ones = -1;
        int twos = nums.length;
        for (int i = 0; i < twos; ++i) {
            int val = nums[i];
            if (val == 0) {
                ones++;
                swap(i, ones);
            } else if (val == 2) {
                twos--;
                swap(i, twos);
                i--;
            }
        }
    }

    void swap(int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}