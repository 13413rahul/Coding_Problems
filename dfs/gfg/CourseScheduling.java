package com.company.dfs.gfg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

// https://practice.geeksforgeeks.org/problems/course-schedule/1?page=1&difficulty[]=1&category[]=DFS&sortBy=submissions
public class CourseScheduling {

    // Driver code
    public static void main(String[] args)
    {
        int numTasks = 4;
        int[][] prerequisites = { { 1, 0 }, { 2, 1 }, { 3, 2 } };

        Solution solution = new Solution();
        ArrayList<Integer> v = solution.findOrder(numTasks, prerequisites);

        for (int i = 0; i < v.size(); i++) {
            System.out.print(v.get(i) + " ");
        }
    }

    static public class Solution {


        // Returns adjacency list representation of graph from
        // given set of pairs.
        static ArrayList<HashSet<Integer> > makeGraph(int numTasks, int[][] prerequisites)
        {
            ArrayList<HashSet<Integer> > graph = new ArrayList();
            for (int i = 0; i < numTasks; i++) {
                graph.add(new HashSet<>());
            }

            for (int[] pre : prerequisites) {
                graph.get(pre[1]).add(pre[0]);
            }

            return graph;
        }

        // Does DFS and adds nodes to Topological Sort
        static boolean dfs(ArrayList<HashSet<Integer> > graph, int node, boolean[] onpath, boolean[] visited, ArrayList<Integer> toposort)
        {
            if (visited[node]) {
                return false;
            }

            onpath[node] = visited[node] = true;
            for (int neigh : graph.get(node)) {
                if (onpath[neigh] || dfs(graph, neigh, onpath, visited, toposort)) {
                    return true;
                }
            }

            toposort.add(node);
            return onpath[node] = false;
        }

        // Returns an order of tasks so that all tasks can be
        // finished.
        static ArrayList<Integer> findOrder(int numTasks, int[][] prerequisites)
        {
            ArrayList<HashSet<Integer> > graph = makeGraph(numTasks, prerequisites);
            ArrayList<Integer> toposort = new ArrayList<>();
            boolean[] onpath = new boolean[numTasks];
            boolean[] visited = new boolean[numTasks];
            for (int i = 0; i < numTasks; i++) {
                if (!visited[i] && dfs(graph, i, onpath, visited, toposort)) {
                    return new ArrayList<>();
                }
            }

            Collections.reverse(toposort);
            return toposort;
        }

    }

}
