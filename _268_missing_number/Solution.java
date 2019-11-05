package _268_missing_number;
/*
 * @Author: your name
 *
 * @Date: 2019-11-04 16:37:09
 *
 * @LastEditTime: 2019-11-04 19:00:28
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_268_missing_number/Solution.java
 */

// https://leetcode.com/problems/missing-number/

// 思路:
// 共n个数, 从[0..n]中选取, 则可以先全部加和, 然后减去现有的数即可

class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += i;
            sum -= nums[i];
        }
        sum += nums.length;
        return sum;
    }
}