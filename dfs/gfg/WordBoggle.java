package com.company.dfs.gfg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://practice.geeksforgeeks.org/problems/word-boggle4143/1
public class WordBoggle {

    public static void main(String[] args) {
        String[] dictionary = {"GEEKS","FOR","QUIZ","GO"};
        char[][] board = {{'G','I','Z'},{'U','E','K'},{'Q','S','E'}};

        Solution solution = new Solution();
        String[] words = solution.wordBoggle(board, dictionary);
        System.out.println(Arrays.toString(words));
    }

    static class Solution {
        public boolean dfs(int row, int col, int ind, char[][] board, String word, int[][] vis) {
            if (ind == word.length()) {
                return true;
            }

            int n = board.length;
            int m = board[0].length;

            vis[row][col] = 1;

            int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
            int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

            for (int i = 0; i < 8; i++) {
                int nrow = row + dx[i];
                int ncol = col + dy[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && board[nrow][ncol] == word.charAt(ind)) {
                    if (dfs(nrow, ncol, ind + 1, board, word, vis)) {
                        return true;
                    }
                }
            }

            vis[row][col] = 0;
            return false;
        }

        public String[] wordBoggle(char board[][], String[] dictionary) {
            List<String> ans = new ArrayList<>();
            int n = board.length;
            int m = board[0].length;

            for (String word : dictionary) {
                boolean flag = true;
                int[][] vis = new int[n][m];

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (board[i][j] == word.charAt(0) && vis[i][j] == 0 && dfs(i, j, 1, board, word, vis)) {
                            ans.add(word);
                            flag = false;
                            break;
                        }
                    }
                    if (!flag) {
                        break;
                    }
                }
            }

            String[] res = new String[ans.size()];
            ans.toArray(res);
            return res;
        }

    }

}
