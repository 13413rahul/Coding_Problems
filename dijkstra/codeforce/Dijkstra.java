package com.company.dijkstra.codeforce;

// https://codeforces.com/problemset/problem/20/C
import java.io.*;
import java.util.*;

public class Dijkstra {
    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static int n, m;
    static final int MAX = 100005;
    static final int inf = Integer.MAX_VALUE;
    static ArrayList<Pair>[] adj;
    static int[] dist;
    static int[] prev;

    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);

        n = input.nextInt();
        m = input.nextInt();

        adj = new ArrayList[MAX];
        dist = new int[MAX];
        prev = new int[MAX];

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
            dist[i] = inf;
        }

        for (int i = 1; i <= m; i++) {
            int u = input.nextInt();
            int v = input.nextInt();
            int w = input.nextInt();
            adj[u].add(new Pair(v, w));
            adj[v].add(new Pair(u, w));
        }

        dijkstra(1);

        findPath(1, n);

    }

    public static void dijkstra(int start) {
        boolean[] visited = new boolean[n + 1]; // tối ưu
        PriorityQueue<Pair> queue =
                new PriorityQueue<>(Comparator.comparingInt(pair -> pair.second));
        Arrays.fill(dist, inf);
        queue.add(new Pair(start, 0));
        dist[start] = 0;
        while (!queue.isEmpty()) {
            Pair element = queue.poll();
            if (visited[element.first]) {
                continue;
            }
            visited[element.first] = true;
            for (Pair x : adj[element.first]) {
                int v = x.first;
                int c = x.second;
                if (!visited[v] && dist[v] > dist[element.first] + c) {
                    dist[v] = dist[element.first] + c;
                    prev[v] = element.first;
                    queue.add(new Pair(v, dist[v]));
                }
            }
        }
    }

    public static void findPath(int start, int end) {
        LinkedList<Integer> path = new LinkedList<>();
        int current = end;
        if (dist[end] != inf) {
            while (current != start) {
                path.addFirst(current);
                current = prev[current];
            }
            path.addFirst(start);
            for (int x : path) {
                System.out.print(x + " ");
            }
        } else {
            System.out.println(-1);
        }
    }
}
