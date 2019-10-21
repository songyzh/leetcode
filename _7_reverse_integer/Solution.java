/*
 * @Author: your name
 * @Date: 2019-10-20 20:51:56
 * @LastEditTime: 2019-10-20 22:02:43
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/7_easy_reverse-integer/Solution.java
 */

package _7_reverse_integer;

// https://leetcode.com/problems/reverse-integer/
// 思路:
// 翻转后的数字, 可能超过Integer的最大最小值
// 负数先转为正数, 再进行处理, 此时也需考虑越界

class Solution {
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        int sign = 1;
        if (x < 0) {
            x *= -1;
            sign = -1;
        }
        int ret = 0;
        while (x > 0) {
            if (ret > Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE / 10 && x > Integer.MAX_VALUE % 10)) {
                return 0;
            }
            ret = ret * 10 + x % 10;
            x /= 10;
        }
        return ret * sign;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(1234));
    }
}
