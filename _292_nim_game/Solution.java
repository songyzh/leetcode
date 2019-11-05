package _292_nim_game;
/*
 * @Author: your name
 *
 * @Date: 2019-11-05 14:10:38
 *
 * @LastEditTime: 2019-11-05 14:12:08
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_292_nim_game/Solution.java
 */

// https://leetcode.com/problems/nim-game/

// 思路:
// 1, ,2, 3可赢
// 4不可赢
// 5先拿1个, 可赢, 同理6, 7

class Solution {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}