package __60_permutation_sequence;

import java.util.Arrays;

/*
 * @Description:
 * @Author: syzh
 * @Date: 2019-11-16 21:45:10
 * @LastEditors: syzh
 * @LastEditTime: 2019-11-17 11:12:59
 * @FilePath: /leetcode/_60_permutation_sequence/Solution.java
 * @Github: https://github.com/songyzh
 */

// https://leetcode.com/problems/permutation-sequence/

// 思路:
// 不断寻求排列的下一个值, 执行n-1次, 类似动态规划的思路
// 2. https://leetcode.com/problems/permutation-sequence/discuss/22507/%22Explain-like-I'm-five%22-Java-Solution-in-O(n)

class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder first = new StringBuilder();
        for (int i = 1; i <= n; ++i) {
            first.append(i);
        }
        for (int i = 0; i < k - 1; ++i) {
            first = helper(first);
        }
        return first.toString();
    }

    StringBuilder helper(StringBuilder s) {
        char[] ca = s.toString().toCharArray();
        // 找到此序列的下一个, 163542
        int index = -1;
        for (int i = 0; i < s.length() - 1; ++i) {
            if (s.charAt(i) < s.charAt(i + 1)) {
                index = i;
            }
        }
        // 找到比3大的最小的数
        int nextSmallIndex = index + 1;
        for (int i = index + 2; i < s.length(); ++i) {
            if (ca[i] > ca[index]) {
                nextSmallIndex = i;
            }
        }
        // 交换位置
        char tmp = ca[index];
        ca[index] = ca[nextSmallIndex];
        ca[nextSmallIndex] = tmp;
        // index后面的部分排序
        Arrays.sort(ca, index + 1, ca.length);
        return new StringBuilder(new String(ca));
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getPermutation(3, 5));
    }
}