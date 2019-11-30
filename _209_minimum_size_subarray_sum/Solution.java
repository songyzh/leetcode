package _209_minimum_size_subarray_sum;
/*
 * @Description:
 *
 * @Author: syzh
 *
 * @Date: 2019-11-22 13:12:09
 *
 * @LastEditors: syzh
 *
 * @LastEditTime: 2019-11-22 14:39:05
 *
 * @FilePath: /leetcode/_209_minimum_size_subarray_sum/Solution.java
 *
 * @Github: https://github.com/songyzh
 */

// https://leetcode.com/problems/minimum-size-subarray-sum/

// 思路:
// 遍历数组, 以i为终止节点, 如果长度为l的的子数组满足条件, 则维持这个窗口, 查找长度为l-1 ~ 1长度的是否满足条件

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0, from = 0, win = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                win = Math.min(win, i - from + 1);
                sum -= nums[from++];
            }
        }
        return (win == Integer.MAX_VALUE) ? 0 : win;
    }
}
