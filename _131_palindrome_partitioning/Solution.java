package _131_palindrome_partitioning;
/*
 * @Author: your name
 *
 * @Date: 2019-11-14 08:50:18
 *
 * @LastEditTime: 2019-11-14 09:22:27
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_131_palindrome_partitioning/Solution.java
 */

import java.util.ArrayList;

// https://leetcode.com/problems/palindrome-partitioning/

import java.util.List;

// 思路:
// 回溯法处理

class Solution {
    String str;
    List<List<String>> ret = new ArrayList<>();

    public List<List<String>> partition(String s) {
        this.str = s;
        helper(new ArrayList<>(), 0, str.length() - 1);
        return ret;
    }

    void helper(List<String> current, int start, int end) {
        if (start > end) {
            ret.add(current);
            return;
        }
        for (int i = start; i <= end; ++i) {
            String currentSub = str.substring(start, i + 1);
            if (!isPalindrome(currentSub)) {
                continue;
            }
            List<String> currentCopy = new ArrayList<>(current);
            currentCopy.add(currentSub);
            helper(currentCopy, i + 1, end);
        }
    }

    boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] ca = s.toCharArray();
        while (i < j) {
            if (ca[i] != ca[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().partition("efe"));
    }
}