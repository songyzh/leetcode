/*
 * @Author: your name
 * @Date: 2019-10-20 20:41:03
 * @LastEditTime: 2019-10-21 18:23:18
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/1_easy_two-sum.java
 */

package _1_two_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum/

// 思路:
// 遍历数列, 把已处理过的数字及其index记录进一个map.
// 遍历时, 检查target-current是否在map中.
// 若存在, 则得到答案

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> lookup = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int current = nums[i];
            int complement = target - current;
            if (lookup.containsKey(complement)) {
                return new int[] { lookup.get(complement), i };
            }
            lookup.put(current, i);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().twoSum(new int[] { 2, 3, 4, 5 }, 9)));
    }
}
