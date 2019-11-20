package __139_word_break;
/*
 * @Description:
 *
 * @Author: syzh
 *
 * @Date: 2019-11-19 18:32:39
 *
 * @LastEditors: syzh
 *
 * @LastEditTime: 2019-11-19 21:33:40
 *
 * @FilePath: /leetcode/_139_word_break/Solution.java
 *
 * @Github: https://github.com/songyzh
 */

import java.util.List;

// https://leetcode.com/problems/word-break/

// 思路:
// 递归会超时, 使用dp

public class Solution {
    public boolean wordBreak(String s, List<String> dict) {
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            if (dict.contains(s.substring(0, i + 1))) {
                dp[i] = true;
                continue;
            }
            for (int j = 0; j < i; ++j) {
                if (dp[j] && dict.contains(s.substring(j + 1, i + 1))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length() - 1];
    }
}