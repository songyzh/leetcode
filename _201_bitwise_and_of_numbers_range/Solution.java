package _201_bitwise_and_of_numbers_range;
/*
 * @Description:
 *
 * @Author: syzh
 *
 * @Date: 2019-11-21 20:05:48
 *
 * @LastEditors: syzh
 *
 * @LastEditTime: 2019-11-21 21:36:45
 *
 * @FilePath: /leetcode/_201_bitwise_and_of_numbers_range/Solution.java
 *
 * @Github: https://github.com/songyzh
 */

// https://leetcode.com/problems/bitwise-and-of-numbers-range/

// 思路:
//  0 <= m <= n <= 2147483647, 则31位肯定为0,
// 第30位上, 最小的在m, 最大的在n
// 同理其他位

class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int zeros = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            zeros++;
        }
        return m << zeros;
    }
}