package __207_course_schedule;
/*
 * @Description:
 *
 * @Author: syzh
 *
 * @Date: 2019-11-22 09:31:20
 *
 * @LastEditors: syzh
 *
 * @LastEditTime: 2019-11-22 10:25:24
 *
 * @FilePath: /leetcode/_207_course_schedule/Solution.java
 *
 * @Github: https://github.com/songyzh
 */

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/course-schedule/

// 思路:
// dp

class Solution {
    boolean[] dp;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        dp = new boolean[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            if (!helper(i, prerequisites, new HashSet<>())) {
                return false;
            }
            dp[i] = true;
        }
        return true;
    }

    boolean helper(int course, int[][] prerequisites, Set<Integer> path) {
        if (path.contains(course)) {
            return false;
        }
        for (int[] pr : prerequisites) {
            if (pr[0] == course) {
                int pre = pr[1];
                boolean current;
                if (dp[pre]) {
                    current = true;
                } else {
                    Set<Integer> pathNew = new HashSet<>(path);
                    pathNew.add(course);
                    current = helper(pre, prerequisites, pathNew);
                }
                if (!current) {
                    return false;
                }
            }
        }
        return true;
    }
}