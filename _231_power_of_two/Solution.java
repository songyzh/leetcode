package _231_power_of_two;
/*
 * @Author: your name
 *
 * @Date: 2019-11-03 11:57:10
 *
 * @LastEditTime: 2019-11-03 12:04:32
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_231_power_of_two/Solution.java
 */

// https://leetcode.com/problems/power-of-two/

// 思路:
// 1. 2的次方, 二进制为1后面若干个0
// 2. n & (n - 1) == 0

class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && ((n & (n - 1)) == 0);
    }
}