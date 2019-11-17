package _50_pow_x_n;
/*
 * @Author: your name
 *
 * @Date: 2019-11-15 22:29:08
 *
 * @LastEditTime: 2019-11-16 10:59:13
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_50_pow_x_n/Solution.java
 */

// https://leetcode.com/problems/powx-n/

// 思路:
// 考虑x的符号
// 2. 递归(会超时)

class Solution {
    public double myPow(double x, int n) {
        double ret = 1;
        if (n == Integer.MIN_VALUE) {
            ret = 1 / x;
            n++;
        }
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        int cnt = 1;
        double ox = x;
        while (n > 0) {
            if (n >= cnt) {
                ret *= x;
                n -= cnt;
                x = x * x;
                cnt *= 2;
            } else {
                x = ox;
                cnt = 1;
            }
        }
        return ret;
    }
}