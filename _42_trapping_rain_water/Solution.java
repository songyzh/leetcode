package _42_trapping_rain_water;
/*
 * @Author: your name
 *
 * @Date: 2019-11-15 17:49:43
 *
 * @LastEditTime: 2019-11-15 18:25:58
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_42_trapping_rain_water/Solution.java
 */

// https://leetcode.com/problems/trapping-rain-water/

// 思路:
// 计算每个点的左边最高高度, 右边最高高度, 然后计算此点上部能有多少水

class Solution {
    public int trap(int[] height) {
        int ret = 0;
        int[] leftHeights = new int[height.length];
        for (int i = 1; i < leftHeights.length; ++i) {
            leftHeights[i] = Math.max(leftHeights[i - 1], height[i - 1]);
        }
        int[] rightHeights = new int[height.length];
        for (int i = rightHeights.length - 2; i >= 0; --i) {
            rightHeights[i] = Math.max(rightHeights[i + 1], height[i + 1]);
        }
        for (int i = 0; i < height.length; ++i) {
            int wallHeight = Math.min(leftHeights[i], rightHeights[i]);
            int water = wallHeight - height[i];
            ret += Math.max(water, 0);
        }
        return ret;
    }
}