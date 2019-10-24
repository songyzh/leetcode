package _69_sqrt_x;
/*
 * @Author: your name
 * @Date: 2019-10-23 08:46:40
 * @LastEditTime: 2019-10-23 09:07:07
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/_69_sqrt_x/Solution.java
 */

// https://leetcode.com/problems/sqrtx/

// 思路:
// x的平方根, 必然在1..x之间
// 从此数列的中间开始查找, 使用二分查找, 不断缩小范围
// 需要注意整型数字的overflow问题

class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int left = 1;
        int right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int pivot = x / mid;
            if (mid == pivot) {
                return mid;
            }
            if (mid < pivot) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().mySqrt(2));
        System.out.println(new Solution().mySqrt(3));
        System.out.println(new Solution().mySqrt(10));
        System.out.println(new Solution().mySqrt(82));

    }
}