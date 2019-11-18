package _77_combinations;
/*
 * @Description:
 *
 * @Author: syzh
 *
 * @Date: 2019-11-18 12:02:25
 *
 * @LastEditors: syzh
 *
 * @LastEditTime: 2019-11-18 12:48:02
 *
 * @FilePath: /leetcode/_77_combinations/Solution.java
 *
 * @Github: https://github.com/songyzh
 */

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combinations/

// 思路:
// 回溯
// 2. 递归 https://www.quora.com/How-can-you-prove-Pascals-formula-that-C-n-k-C-n-1-k-+C-n-1-k-1
// 从1..n中选择k个数
// 如果选n, 则从剩下1..n-1个数中选k-1个数
// 如果不选n, 则从1..n-1中选k个数
// 相加即可

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        if (k > n || k < 0) {
            return ret;
        }
        if (k == 0) {
            // 起点
            ret.add(new ArrayList<>());
            return ret;
        }
        List<List<Integer>> prev = combine(n - 1, k - 1);
        for (List<Integer> p : prev) {
            p.add(n);
        }
        prev.addAll(combine(n - 1, k));
        return prev;
    }
}