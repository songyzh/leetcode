package _219_contains_duplicate_ii;
/*
 * @Author: your name
 *
 * @Date: 2019-11-03 10:50:08
 *
 * @LastEditTime: 2019-11-03 11:33:57
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_219_contains_duplicate_ii/Solution.java
 */

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/contains-duplicate-ii/

// 思路:
// 要找相同的数字, 且二者的index <= k
// 可试用滑动的窗口来查找
// 使用hashset来记录每个数字的出现, 并随窗口调整

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        k = Math.min(k, nums.length - 1);
        Set<Integer> lookup = new HashSet<>();
        for (int i = 0; i <= k; ++i) {
            if (lookup.contains(nums[i])) {
                return true;
            }
            lookup.add(nums[i]);
        }
        for (int i = k + 1; i < nums.length; ++i) {
            lookup.remove(nums[i - k - 1]);
            if (lookup.contains(nums[i])) {
                return true;
            }
            lookup.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().containsNearbyDuplicate(new int[] { 1, 2, 3, 1 }, 3));
    }
}