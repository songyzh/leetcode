package _342_power_of_four;
/*
 * @Author: your name
 * @Date: 2019-11-07 18:00:29
 * @LastEditTime: 2019-11-07 18:01:52
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/_342_power_of_four/Solution.java
 */

// https://leetcode.com/problems/power-of-four/

// 思路:
// 一次右移2位

class Solution {
    public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        }
        while (num % 4 == 0) {
            num >>= 2;
        }
        return num == 1;
    }
}