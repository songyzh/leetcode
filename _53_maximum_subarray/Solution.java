package _53_maximum_subarray;
/*
 * @Author: your name
 *
 * @Date: 2019-10-21 18:50:08
 *
 * @LastEditTime: 2019-10-22 10:15:10
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_53_maximum_subarray/Solution.java
 */

// https://leetcode.com/problems/maximum-subarray/

// 思路:
// 遍历数组, 以各个元素为结尾的子数组, 可覆盖所有情况
// 左侧维护一个最大和
// 以各个元素为结尾的子数组, 有两种情况: 包含左边和自己; 只包含自己

class Solution {
    public int maxSubArray(int[] nums) {
        int ret = nums[0];
        int left = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            int num = nums[i];
            int currentMax = left > 0 ? left + num : num;
            ret = ret > currentMax ? ret : currentMax;
            left = left > 0 ? (left + num) : num;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
    }
}