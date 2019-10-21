package _38_count_and_say;
/*
 * @Author: your name
 * @Date: 2019-10-21 08:27:50
 * @LastEditTime: 2019-10-21 08:38:17
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/_38_count_and_say/Solution.java
 */

// https://leetcode.com/problems/count-and-say/

// 思路:
// 递归或动态规划
// 找到current和previous的关系

class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String prev = countAndSay(n - 1);
        StringBuilder ret = new StringBuilder();
        char currentChar = prev.charAt(0);
        int currentCharCnt = 1;
        for (int i = 1; i < prev.length(); ++i) {
            if (prev.charAt(i) != currentChar) {
                ret.append(currentCharCnt);
                ret.append(currentChar);
                currentChar = prev.charAt(i);
                currentCharCnt = 1;
            } else {
                currentCharCnt++;
            }
        }
        ret.append(currentCharCnt);
        ret.append(currentChar);
        return ret.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countAndSay(1));
        System.out.println(new Solution().countAndSay(4));

    }
}