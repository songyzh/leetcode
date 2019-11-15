package _29_divide_two_integers;
/*
 * @Author: your name
 *
 * @Date: 2019-11-15 09:25:35
 *
 * @LastEditTime: 2019-11-15 09:49:48
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_29_divide_two_integers/Solution.java
 */

// https://leetcode.com/problems/divide-two-integers/

// 思路:
// 先把数字都转化为正数, 然后记录符号

class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == Integer.MIN_VALUE) {
            if (dividend == Integer.MIN_VALUE) {
                return 1;
            }
            return 0;
        }
        int ret = 0;
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
            if (divisor > 0) {
                dividend += divisor;
                ret = 1;
            } else {
                dividend -= divisor;
                ret = 1;
            }
        }
        int sign = (dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0) ? 1 : -1;
        dividend = dividend > 0 ? dividend : -dividend;
        divisor = divisor > 0 ? divisor : -divisor;
        int pivot = 0;
        while (dividend >= divisor) {
            if (pivot < 31 && dividend >= divisor << pivot) {
                dividend -= divisor << pivot;
                ret += 1 << pivot;
                pivot++;
            } else {
                pivot = 0;
            }
        }
        return ret * sign;
    }
}