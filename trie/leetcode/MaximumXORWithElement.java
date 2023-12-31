package com.company.trie.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

// https://leetcode.com/problems/maximum-xor-with-an-element-from-array/description/
public class MaximumXORWithElement {

    static class Node {

        Node links[] = new Node[2];

        public Node() {
        }

        boolean containsKey(int ind) {
            return (links[ind] != null);
        }

        Node get(int ind) {
            return links[ind];
        }

        void put(int ind, Node node) {
            links[ind] = node;
        }
    };

    static class Trie {
        private static Node root;

        //Initialize your data structure here

        Trie() {
            root = new Node();
        }

        //Inserts a word into the trie

        public static void insert(int num) {
            Node node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (!node.containsKey(bit)) {
                    node.put(bit, new Node());
                }
                node = node.get(bit);
            }
        }

        public int getMax(int num) {
            Node node = root;
            int maxNum = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.containsKey(1 - bit)) {
                    maxNum = maxNum | (1 << i);
                    node = node.get(1 - bit);
                } else {
                    node = node.get(bit);
                }
            }
            return maxNum;
        }
    };

    static class Solution {
        public static ArrayList<Integer> maxXorQueries(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> queries) {
            Collections.sort(arr);
            ArrayList<ArrayList<Integer>> offlineQueries = new ArrayList<ArrayList<Integer>>();
            int m = queries.size();
            for (int i = 0; i < m; i++) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(queries.get(i).get(1));
                temp.add(queries.get(i).get(0));
                temp.add(i);
                offlineQueries.add(temp);
            }

            Collections.sort(offlineQueries, new Comparator<ArrayList<Integer>>() {
                @Override
                public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                    return a.get(0).compareTo(b.get(0));
                }
            });

            int ind = 0;
            int n = arr.size();
            Trie trie = new Trie();
            ArrayList<Integer> ans = new ArrayList<Integer>(m);
            for (int i = 0; i < m; i++) ans.add(-1);
            for (int i = 0; i < m; i++) {
                while (ind < n && arr.get(ind) <= offlineQueries.get(i).get(0)) {
                    trie.insert(arr.get(ind));
                    ind++;
                }
                int queryInd = offlineQueries.get(i).get(2);
                if (ind != 0) ans.set(queryInd, trie.getMax(offlineQueries.get(i).get(1)));
                else ans.set(queryInd, -1);
            }
            return ans;
        }
    }

    static class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int t;
            t = sc.nextInt();
            for (int j = 0; j < t; j++) {
                int n, m;
                n = sc.nextInt();
                m = sc.nextInt();
                ArrayList<Integer> arr = new ArrayList<Integer>(n);
                for (int i = 0; i < n; i++) {
                    arr.add(sc.nextInt());
                }

                ArrayList<ArrayList<Integer>> queries = new ArrayList<ArrayList<Integer>>(m);

                for (int i = 0; i < m; i++) {
                    ArrayList<Integer> temp = new ArrayList<Integer>(2);
                    temp.add(sc.nextInt());
                    temp.add(sc.nextInt());
                    queries.add(temp);
                }

                Solution s = new Solution();

                ArrayList<Integer> ans = new ArrayList<Integer>(n);
                ans = s.maxXorQueries(arr, queries);

                for (int it : ans) {
                    System.out.print(it + " ");
                }
                System.out.print('\n');
            }
        }
    }
}
