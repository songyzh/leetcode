package _299_bulls_and_cows;
/*
 * @Author: your name
 *
 * @Date: 2019-11-05 14:29:26
 *
 * @LastEditTime: 2019-11-07 16:28:34
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_299_bulls_and_cows/Solution.java
 */

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/bulls-and-cows/

// 思路:
// 首先读懂题:
// 数字和位置都猜中, 叫做bulls,
// 数字对了, 位置不对, 叫做cows
// 答案和猜测都可以有重复
// 先找bulls, 再找cows

class Solution {
    public String getHint(String secret, String guess) {
        int bull = 0;
        int cow = 0;
        Map<Character, Integer> secretMap = new HashMap<>();
        Map<Character, Integer> guessMap = new HashMap<>();
        for (int i = 0; i < secret.length(); ++i) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) {
                bull++;
            } else {
                if (secretMap.containsKey(s)) {
                    secretMap.put(s, secretMap.get(s) + 1);
                } else {
                    secretMap.put(s, 1);
                }
                if (guessMap.containsKey(g)) {
                    guessMap.put(g, guessMap.get(g) + 1);
                } else {
                    guessMap.put(g, 1);
                }
            }
        }
        for (char c : guessMap.keySet()) {
            if (secretMap.containsKey(c)) {
                cow += Math.min(guessMap.get(c), secretMap.get(c));
            }
        }
        return bull + "A" + cow + "B";
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getHint("11", "11"));
    }
}