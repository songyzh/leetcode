package _11_container_with_most_water;
/*
 * @Author: your name
 *
 * @Date: 2019-11-14 15:57:51
 *
 * @LastEditTime: 2019-11-14 16:16:05
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_11_container_with_most_water/Solution.java
 */

// https://leetcode.com/problems/container-with-most-water/

// 思路:
// 左右双指针. 双指针中较低的那个, 以其为边缘的容器, 最大就是初始状态最远的时候. 之后就可以舍弃掉, 继续计算

class Solution {
    public int maxArea(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int ret = 0;
        while (left < right) {
            int bottomLength = right - left;
            int sideLength = Math.min(height[left], height[right]);
            ret = ret > bottomLength * sideLength ? ret : bottomLength * sideLength;
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return ret;
    }
}