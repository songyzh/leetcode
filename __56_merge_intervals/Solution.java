package __56_merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @Author: your name
 *
 * @Date: 2019-11-16 16:34:52
 *
 * @LastEditTime: 2019-11-16 21:14:19
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_56_merge_intervals/Solution.java
 */
// https://leetcode.com/problems/merge-intervals/

// 思路:
// 找到每一个区间和下一个区间, 是否有重叠

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ret = new ArrayList<>();
        if (intervals.length == 0) {
            return new int[][] {};
        }
        Arrays.sort(intervals, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });
        for (int i = 1; i < intervals.length; ++i) {
            int[] prev = intervals[i - 1];
            int[] current = intervals[i];
            if (prev[1] < current[0] || current[1] < prev[0]) {
                ret.add(new int[] { prev[0], prev[1] });
            } else {
                intervals[i] = new int[] { Math.min(prev[0], current[0]), Math.max(prev[1], current[1]) };
            }
        }
        ret.add(intervals[intervals.length - 1]);
        return ret.toArray(new int[ret.size()][]);
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.deepToString(new Solution().merge(new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } })));
    }
}