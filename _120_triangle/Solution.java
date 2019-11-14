package _120_triangle;
/*
 * @Author: your name
 *
 * @Date: 2019-11-13 18:34:05
 *
 * @LastEditTime: 2019-11-13 20:38:15
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_120_triangle/Solution.java
 */

// https://leetcode.com/problems/triangle/

import java.util.List;

// 思路:
// 从上到下加和, 最终在最后一层求解

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        for (int i = n - 2; i >= 0; --i) {
            List<Integer> curr = triangle.get(i);
            List<Integer> next = triangle.get(i + 1);
            for (int j = 0; j < curr.size(); ++j) {
                int minDown = next.get(j) < next.get(j + 1) ? next.get(j) : next.get(j + 1);
                curr.set(j, minDown + curr.get(j));
            }
        }
        return triangle.get(0).get(0);
    }
}