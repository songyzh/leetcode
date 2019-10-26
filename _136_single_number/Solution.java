package _136_single_number;
/*
 * @Author: your name
 *
 * @Date: 2019-10-26 13:08:33
 *
 * @LastEditTime: 2019-10-26 13:11:10
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_136_single_number/Solution.java
 */

// https://leetcode.com/problems/single-number/

// 思路:
// 1. 可以把所有值异或, 最后得到结果
// 2. 可以使用set保存值, 遇到相同的则删除, 最终得到结果

class Solution {
    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int num : nums) {
            ret ^= num;
        }
        return ret;
    }
}