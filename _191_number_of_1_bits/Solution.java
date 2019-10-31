package _191_number_of_1_bits;
/*
 * @Author: your name
 *
 * @Date: 2019-10-31 21:26:09
 *
 * @LastEditTime: 2019-10-31 21:29:23
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_191_number_of_1_bits/Solution.java
 */

// https://leetcode.com/problems/number-of-1-bits/

// 思路:
// n不断右移, 遇到1时, 计数器加一
// 需要注意, 不能以(n > 0)作为条件, 因为n可能为负数

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ret = 0;
        while (n != 0) {
            ret += (n & 1);
            n >>>= 1;
        }
        return ret;
    }
}