package _187_repeated_dna_sequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @Description:
 *
 * @Author: syzh
 *
 * @Date: 2019-11-21 18:10:56
 *
 * @LastEditors: syzh
 *
 * @LastEditTime: 2019-11-21 18:31:54
 *
 * @FilePath: /leetcode/_187_repeated_dna_sequences/Solution.java
 *
 * @Github: https://github.com/songyzh
 */
// https://leetcode.com/problems/repeated-dna-sequences/

// 思路:
// 使用set保存

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> ret = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; ++i) {
            String current = s.substring(i, i + 10);
            if (seen.contains(current)) {
                ret.add(current);
            } else {
                seen.add(current);
            }
        }
        return new ArrayList<>(ret);
    }
}