package __133_clone_graph;

import java.util.List;

/*
 * @Author: your name
 *
 * @Date: 2019-11-14 09:28:48
 *
 * @LastEditTime: 2019-11-14 09:38:39
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath:
 * /leetcode/__95_unique_binary_search_trees_ii/_133_clone_graph/Solution.java
 */
// https://leetcode.com/problems/clone-graph/

// 思路:
// 使用set记录已处理过的节点

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
    }

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};

class Solution {
    public Node cloneGraph(Node node) {
        Node newNode = new Node();
        newNode.val = node.val;
        return newNode;
    }
}