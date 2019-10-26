package _125_valid_palindrome;
/*
 * @Author: your name
 *
 * @Date: 2019-10-26 12:55:35
 *
 * @LastEditTime: 2019-10-26 13:07:47
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_125_valid_palindrome/Solution.java
 */

// https://leetcode.com/problems/valid-palindrome/

// 思路:
// 把整个字符串转为小写, 去除大小写的影响
// 使用头尾双指针

class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }
        s = s.toLowerCase();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            char startChar = s.charAt(start);
            if (!isAlphaNum(startChar)) {
                start++;
                continue;
            }
            char endChar = s.charAt(end);
            if (!isAlphaNum(endChar)) {
                end--;
                continue;
            }
            if (startChar != endChar) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    boolean isAlphaNum(char c) {
        return '0' <= c && c <= '9' || 'a' <= c && c <= 'z';
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome("A man, a plan, a canal: Panama"));
    }
}