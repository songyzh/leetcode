package _134_gas_station;
/*
 * @Author: your name
 *
 * @Date: 2019-11-14 09:39:45
 *
 * @LastEditTime: 2019-11-14 09:53:07
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_134_gas_station/Solution.java
 */

// https://leetcode.com/problems/gas-station/

// 思路:
// 扩展两个数组以形成环

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int ret = -1;
        outer: for (int i = 0; i < gas.length; ++i) {
            int total = 0;
            int start = i;
            for (int j = 0; j < gas.length; ++j) {
                total += gas[start % gas.length];
                total -= cost[start % gas.length];
                if (total < 0) {
                    continue outer;
                }
                start++;
            }
            return i;
        }
        return ret;
    }
}