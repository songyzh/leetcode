package _213_house_robber_ii;
/*
 * @Description:
 *
 * @Author: syzh
 *
 * @Date: 2019-11-22 14:41:57
 *
 * @LastEditors: syzh
 *
 * @LastEditTime: 2019-11-22 15:26:30
 *
 * @FilePath: /leetcode/_213_house_robber_ii/Solution.java
 *
 * @Github: https://github.com/songyzh
 */

// https://leetcode.com/problems/house-robber-ii/

// 思路:
// 划分
// 偷0
// 不偷0

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int ret1 = 0;
        int pprev = 0;
        int prev = 0;
        for (int i = 2; i < nums.length - 1; ++i) {
            int current = Math.max(pprev + nums[i], prev);
            ret1 = ret1 > current ? ret1 : current;
            pprev = prev;
            prev = current;
        }
        ret1 += nums[0];

        int ret3 = 0;
        pprev = 0;
        prev = 0;
        for (int i = 1; i < nums.length; ++i) {
            int current = Math.max(pprev + nums[i], prev);
            ret3 = ret3 > current ? ret3 : current;
            pprev = prev;
            prev = current;
        }
        ret3 = ret1 > ret3 ? ret1 : ret3;
        return ret3;
    }
}
