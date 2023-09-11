package com.company.union_find.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/surrounded-regions/
public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X' ,'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        Solution3 solution = new Solution3();
        solution.solve(board);

        for(char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }
}

class Solution3 {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        int size = n * m + 1;
        UnionFind3 uf = new UnionFind3(size);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if((j == m - 1 || i == n - 1 || j == 0 || i == 0) && board[i][j] == 'O') {
                    uf.union(size - 1, i * m + j);
                }

                if(i + 1 < n && board[i][j] == 'O' && board[i + 1][j] == 'O') {
                    uf.union((i + 1) * m + j, i * m + j);
                }

                if(j + 1 < m && board[i][j] == 'O' && board[i][j + 1] == 'O') {
                    uf.union(i * m + j, i * m + (j + 1));
                }
            }
        }

        int flag = uf.find(size - 1);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 'O' && uf.find(i * m + j) != flag) {
                    board[i][j] = 'X';
                }
            }
        }

    }
}

class UnionFind3 {
    int[] parent;
    UnionFind3(int n) {
        parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

    }

    int find(int n) {
        if(n == parent[n]) {
            return n;
        }

        return parent[n] = find(parent[n]);
    }

    void union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if(pu == pv) {
            return;
        }

        parent[pv] = pu;
    }
}
