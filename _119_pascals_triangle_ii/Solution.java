package _119_pascals_triangle_ii;
/*
 * @Author: your name
 * @Date: 2019-10-26 11:12:02
 * @LastEditTime: 2019-10-26 11:24:40
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/_119_pascals_triangle_ii/Solution.java
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/pascals-triangle-ii/

// 思路:
// 大体思路同118题, 只是此题可以只保存上一个结果即可

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> prev = Arrays.asList(1);
        // 迭代 rowIndex 次
        for (int i = 0; i < rowIndex; ++i) {
            List<Integer> current = new ArrayList<>();
            current.add(1);
            for (int j = 0; j < prev.size() - 1; ++j) {
                current.add(prev.get(j) + prev.get(j + 1));
            }
            current.add(1);
            prev = current;
        }
        return prev;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getRow(3));
    }
}
