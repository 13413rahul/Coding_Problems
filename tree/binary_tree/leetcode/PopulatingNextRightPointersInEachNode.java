package com.company.tree.binary_tree.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
public class PopulatingNextRightPointersInEachNode {
    static class Node {
        int data;
        Node left, right;
        Node next;
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
            next = null;
        }
    }

    public Node connect(Node node) {
        Map<Integer, List<Node>> map = new HashMap<>();
        goDFS(0, node, map);
        for (int key : map.keySet()) {
            List<Node> list = map.get(key);
            for (int i = 1; i < list.size(); i++) {
                list.get(i - 1).next = list.get(i);
            }
        }
        return node;
    }

    private void goDFS(int lvl, Node node, Map<Integer, List<Node>> map) {
        if (node == null) return;

        List<Node> list = map.computeIfAbsent(lvl, k -> new ArrayList<>());
        list.add(node);
        lvl++;
        goDFS(lvl, node.left, map);
        goDFS(lvl, node.right, map);
    }
}
