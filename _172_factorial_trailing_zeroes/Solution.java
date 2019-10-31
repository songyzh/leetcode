package _172_factorial_trailing_zeroes;
/*
 * @Author: your name
 *
 * @Date: 2019-10-26 22:08:40
 *
 * @LastEditTime: 2019-10-26 22:11:28
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_172_factorial_trailing_zeroes/Solution.java
 */

// https://leetcode.com/problems/factorial-trailing-zeroes/

// 思路:
// 0由10构成, 10由2和5构成, 2一定比5多, 因此找5的个数即可
// 注意逢25, 625等, 需要多加1个或2个5

class Solution {
    public int trailingZeroes(int n) {
        int ret = 0;
        while (n > 0) {
            ret += n / 5;
            n /= 5;
        }
        return ret;
    }
}