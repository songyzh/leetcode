package _118_pascals_triangle;
/*
 * @Author: your name
 * @Date: 2019-10-24 09:12:58
 * @LastEditTime: 2019-10-24 09:18:43
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/_118_pascals_triangle/Solution.java
 */

// https://leetcode.com/problems/pascals-triangle/

import java.util.ArrayList;
import java.util.Arrays;

// 思路:
// 可用dp的方法, 把之前的结果保存在集合中, 根据之前的层级, 得出新的层级

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {
            if (i == 0) {
                ret.add(Arrays.asList(1));
            } else if (i == 1) {
                ret.add(Arrays.asList(1, 1));

            }
        }
    }
}