package _190_reverse_bits;
/*
 * @Author: your name
 *
 * @Date: 2019-10-31 21:13:08
 *
 * @LastEditTime: 2019-10-31 21:23:53
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_190_reverse_bits/Solution.java
 */

// https://leetcode.com/problems/reverse-bits/

// 思路:
// 取n & 1可得n的最后一位
// ret <<= 1, 然后 + 最后一位即可
// 需要注意, 至少此过程要重复32次

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ret = 0;
        for (int i = 0; i < 32; ++i) {
            ret <<= 1;
            ret += (n & 1);
            n >>>= 1;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseBits(43261596));
    }
}