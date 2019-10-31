package _189_rotate_array;
/*
 * @Author: your name
 *
 * @Date: 2019-10-27 09:24:35
 *
 * @LastEditTime: 2019-10-31 11:49:23
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_189_rotate_array/Solution.java
 */

import java.util.Arrays;

// https://leetcode.com/problems/rotate-array/

// 思路:
// k = k % nums.length
// 后k个数字, 存储起来; 前 len - k 个数字, 向右移动k; 将额外存储的后k个数字补在前面

class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;

        int[] extra = new int[k];
        for (int i = 0; i < k; ++i) {
            extra[i] = nums[i + len - k];
        }
        for (int i = len - k - 1; i >= 0; --i) {
            nums[i + k] = nums[i];
        }
        for (int i = 0; i < extra.length; ++i) {
            nums[i] = extra[i];
        }
    }

    public static void main(String[] args) {
        int[] ia = new int[] { 1, 2, 3, 4, 5 };
        new Solution().rotate(ia, 2);
        System.out.println(Arrays.toString(ia));
    }
}