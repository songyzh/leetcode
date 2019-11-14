package _93_restore_ip_addresses;
/*
 * @Author: your name
 *
 * @Date: 2019-11-11 15:16:28
 *
 * @LastEditTime: 2019-11-11 15:51:38
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_93_restore_ip_addresses/Solution.java
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/restore-ip-addresses/

// 思路:
// 回溯法求解
// 需要注意最后是否把string用完, 以及去重, 以及0开头的情况
class Solution {
    Set<String> ret = new HashSet<>();
    String str = null;

    public List<String> restoreIpAddresses(String s) {
        str = s;
        helper(new ArrayList<>(), 0);
        return new ArrayList<>(ret);
    }

    void helper(List<String> current, int index) {
        if (current.size() == 4) {
            if (index != str.length()) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (String s : current) {
                sb.append(s);
                sb.append(".");
            }
            ret.add(sb.substring(0, sb.length() - 1));
            return;
        }
        for (int i = 1; i < 4; ++i) {
            int end = index + i;
            if (end > str.length()) {
                break;
            }
            String subStr = str.substring(index, end);
            if (Integer.valueOf(subStr) > 255 || (subStr.startsWith("0") && subStr.length() > 1)) {
                break;
            }
            List<String> newCurrent = new ArrayList<>(current);
            newCurrent.add(subStr);
            helper(newCurrent, end);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().restoreIpAddresses("25525511135"));
    }
}