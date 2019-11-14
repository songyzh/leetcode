package _367_valid_perfect_square;
/*
 * @Author: your name
 *
 * @Date: 2019-11-08 09:20:41
 *
 * @LastEditTime: 2019-11-08 09:37:11
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_367_valid_perfect_square/Solution.java
 */

// https://leetcode.com/problems/valid-perfect-square/

// 思路:
// 使用二分查找的方式, 找出此数的开方

class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 0) {
            return false;
        }
        if (num <= 1) {
            return true;
        }
        int left = 2;
        int right = num - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid == num / mid) {
                return mid * mid == num;
            } else if (mid > num / mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right * right == num;
    }
}