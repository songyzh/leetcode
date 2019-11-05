package _283_move_zeroes;
/*
 * @Author: your name
 *
 * @Date: 2019-11-05 13:27:30
 *
 * @LastEditTime: 2019-11-05 13:36:25
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_283_move_zeroes/Solution.java
 */

import java.util.Arrays;

// https://leetcode.com/problems/move-zeroes/

// 思路:
// 遍历数组, 遇到非0数字, 不作处理; 遇到0, 则记录该下标. 再次遇到非0时, 交换二者

class Solution {
    public void moveZeroes(int[] nums) {
        int zeroIndex = -1;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0 && zeroIndex == -1) {
                continue;
            }
            if (nums[i] == 0 && zeroIndex == -1) {
                zeroIndex = i;
                continue;
            }
            if (nums[i] != 0 && zeroIndex != -1) {
                int tmp = nums[i];
                nums[i] = 0;
                nums[zeroIndex++] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] ia = new int[] { 0, 1, 0, 3, 12 };
        new Solution().moveZeroes(ia);
        System.out.println(Arrays.toString(ia));
    }
}