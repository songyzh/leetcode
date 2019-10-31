/*
 * @Author: your name
 * @Date: 2019-10-27 09:16:05
 * @LastEditTime: 2019-10-27 09:19:33
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/_175_combine_two_tables/Solution.java
 */
-- https://leetcode.com/problems/combine-two-tables/

-- 思路:
-- 左连接即可

select FirstName, LastName, City, `State` from Person left join Address on Person.PersonId = Address.PersonId;