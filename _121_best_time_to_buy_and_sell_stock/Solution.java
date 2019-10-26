package _121_best_time_to_buy_and_sell_stock;
/*
 * @Author: your name
 *
 * @Date: 2019-10-26 11:26:24
 *
 * @LastEditTime: 2019-10-26 11:34:39
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_121_best_time_to_buy_and_sell_stock/Solution.java
 */

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

// 思路:
// 遍历数组, 以某天为卖的节点. 则需要记录当天之前的最低值

class Solution {
    public int maxProfit(int[] prices) {
        int ret = 0;
        if (prices.length == 0) {
            return ret;
        }
        int prevMin = prices[0];
        for (int i = 1; i < prices.length; ++i) {
            int currentProfit = prices[i] - prevMin;
            ret = Math.max(ret, currentProfit);
            prevMin = Math.min(prevMin, prices[i]);
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
    }
}