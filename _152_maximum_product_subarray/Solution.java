package _152_maximum_product_subarray;
/*
 * @Description:
 *
 * @Author: syzh
 *
 * @Date: 2019-11-20 20:23:35
 *
 * @LastEditors: syzh
 *
 * @LastEditTime: 2019-11-20 22:18:40
 *
 * @FilePath: /leetcode/_152_maximum_product_subarray/Solution.java
 *
 * @Github: https://github.com/songyzh
 */

// https://leetcode.com/problems/maximum-product-subarray/

// 思路:
// 负数相乘可为正, 所以需要记录最小值

class Solution {
    public int maxProduct(int[] nums) {
        int ret = Integer.MIN_VALUE;
        int localMax = 1;
        int localMin = 1;
        for (int num : nums) {
            int v1 = localMax * num;
            int v2 = num;
            int v3 = localMin * num;
            localMax = v1 > v2 ? v1 : v2;
            localMax = localMax > v3 ? localMax : v3;
            localMin = v1 < v2 ? v1 : v2;
            localMin = localMin < v3 ? localMin : v3;
            ret = ret > localMax ? ret : localMax;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProduct(new int[] { -2, 0, -1 }));
    }
}