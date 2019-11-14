package _326_power_of_three;
/*
 * @Author: your name
 *
 * @Date: 2019-11-07 16:45:41
 *
 * @LastEditTime: 2019-11-07 16:51:10
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_326_power_of_three/Solution.java
 */

// https://leetcode.com/problems/power-of-three/

// 思路:
// 直接求解

class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}