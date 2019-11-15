package _5_longest_palindromic_substring;
/*
 * @Author: your name
 *
 * @Date: 2019-11-14 15:14:22
 *
 * @LastEditTime: 2019-11-14 15:28:49
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_5_longest_palindromic_substring/Solution.java
 */

// https://leetcode.com/problems/longest-palindromic-substring/

// 思路:
// 有两种对称方式: 1个中心和2个中心
// 遍历所有可能

class Solution {
    String s;

    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        this.s = s;
        String ret = "";
        for (int i = 0; i < s.length() - 1; ++i) {
            String curr = helper1(i);
            ret = ret.length() > curr.length() ? ret : curr;
            curr = helper2(i, i + 1);
            ret = ret.length() > curr.length() ? ret : curr;
        }
        return ret;
    }

    String helper1(int c) {
        int i = c;
        int j = c;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }

    String helper2(int c1, int c2) {
        int i = c1;
        int j = c2;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("cbbd"));
    }
}