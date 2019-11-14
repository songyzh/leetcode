package _137_single_number_ii;
/*
 * @Author: your name
 *
 * @Date: 2019-11-14 10:18:48
 *
 * @LastEditTime: 2019-11-14 11:17:08
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_137_single_number_ii/Solution.java
 */

// https://leetcode.com/problems/single-number-ii/

// 思路:
// 1.
// https://leetcode.com/problems/single-number-ii/discuss/43295/Detailed-explanation-and-generalization-of-the-bitwise-operation-method-for-single-numbers
// 2. 所有数字都是32位的, 一位一位地看, 例如最末一位, 所有数字的最末一位相加, 再%= 3, 如果是1, 则单个数字的最后一位是1; 逐位类推

class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int n : nums)
                if ((n >> i & 1) == 1)
                    sum++;
            sum %= 3;
            res |= sum << i;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().singleNumber(new int[] { 2, 2, 3, 2 }));
    }
}