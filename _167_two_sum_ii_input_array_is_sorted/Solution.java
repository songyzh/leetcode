package _167_two_sum_ii_input_array_is_sorted;
/*
 * @Author: your name
 *
 * @Date: 2019-10-26 17:24:16
 *
 * @LastEditTime: 2019-10-26 20:26:01
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_167_two_sum_ii_input_array_is_sorted/Solution.java
 */

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

// 思路:
// 数组已排序, 则可用双指针的方式向中间靠拢

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int currentSum = numbers[left] + numbers[right];
            if (currentSum == target) {
                return new int[] { left + 1, right + 1 };
            }
            if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }
}