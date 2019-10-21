/*
 * @Author: your name
 * @Date: 2019-10-20 21:16:32
 * @LastEditTime: 2019-10-20 22:03:12
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/9_easy_palindrome-number/Solution.java
 */

// https://leetcode.com/problems/palindrome-number/

// 思路:
// 负数均为false
// 把低位的数字, 构建新的数
// 如果新构建的数, 等于剩余的
// 或者新构建的数, 大于剩余的, 且/10后二者相等
// 则为true

package _9_easy_palindrome_number;

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        if (x % 10 == 0) {
            return false;
        }
        int lowerPart = 0;
        while (x > lowerPart) {
            lowerPart = lowerPart * 10 + x % 10;
            x /= 10;
        }
        if (x == lowerPart || x == lowerPart / 10) {
            return true;
        }
        return false;
    }
}
