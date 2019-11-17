package _55_jump_game;
/*
 * @Author: your name
 *
 * @Date: 2019-11-16 12:15:58
 *
 * @LastEditTime: 2019-11-16 14:17:49
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_55_jump_game/Solution.java
 */

// https://leetcode.com/problems/jump-game/

// 思路:
// 确保所有0都能跨过
// 从右往左, 把0的位置记录在set中
// 如果遇到可以跨过0的值, 从set中移除
// 注意: 不能一边遍历一边修改set
// 2. 如果最后一点可以到达, 则前面所有点都能到达, 以max记录能到达的最远距离

class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (max >= nums.length - 1) {
                return true;
            }
            if (max < i) {
                return false;
            }
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canJump(new int[] { 5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0 }));
    }
}