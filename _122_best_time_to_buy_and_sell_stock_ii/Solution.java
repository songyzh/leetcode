package _122_best_time_to_buy_and_sell_stock_ii;
/*
 * @Author: your name
 *
 * @Date: 2019-10-26 11:34:25
 *
 * @LastEditTime: 2019-10-26 12:47:53
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_122_best_time_to_buy_and_sell_stock_ii/Solution.java
 */

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

// 思路:
// 遍历数组, 看某天是否可卖出. 如果之前有更低的价格, 则可卖出. 新的买入时机必须为当天之后
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int ret = 0;
        int prevMin = prices[0];
        for (int i = 1; i < prices.length; ++i) {
            int current = prices[i];
            if (current > prevMin) {
                ret += current - prevMin;
            }
            prevMin = current;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
    }
}