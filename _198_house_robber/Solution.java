package _198_house_robber;
/*
 * @Author: your name
 *
 * @Date: 2019-10-31 21:30:09
 *
 * @LastEditTime: 2019-10-31 21:43:05
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_193_valid_phone_numbers/Solution.java
 */

// https://leetcode.com/problems/house-robber/

// 思路:
// 不能抢劫相邻的房子
// 可以使用dp, 子问题为: 以当前房子为最后一间抢劫的房子
// 注意: 需要处理nums为空的情况

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] ret = new int[nums.length];
        for (int i = 0; i < ret.length; ++i) {
            if (i == 0) {
                ret[0] = nums[0];
            } else if (i == 1) {
                ret[1] = Math.max(nums[0], nums[1]);
            } else {
                ret[i] = Math.max(ret[i - 2] + nums[i], ret[i - 1]);
            }
        }
        return ret[ret.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().rob(new int[] { 2, 7, 9, 3, 1 }));
    }
}