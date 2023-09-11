package com.company.bfs.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://leetcode.com/problems/01-matrix/description/
public class NearestZeroFromEachCell {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int row = sc.nextInt();
//        int col = sc.nextInt();
//        int[][] matrix = new int[row][col];
//        for(int i = 0; i < row; i++) {
//            for(int j = 0; j < col; j++) {
//                matrix[i][j] = sc.nextInt();
//            }
//        }

        int[][] matrix = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        Solution solution = new Solution();
        int[][] distances = solution.updateMatrix(matrix);

        for(int[] distance : distances) {
            System.out.println(Arrays.toString(distance));
        }

    }

    static class Solution {
        public int[][] updateMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return matrix;
            }

            int rows = matrix.length;
            int cols = matrix[0].length;
            int[][] distances = new int[rows][cols];
            Queue<int[]> queue = new LinkedList<>();

            // Enqueue all 0 cells and set their distances to 0
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (matrix[i][j] == 0) {
                        distances[i][j] = 0;
                        queue.offer(new int[] { i, j });
                    } else {
                        distances[i][j] = Integer.MAX_VALUE;
                    }
                }
            }

            int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

            // Perform BFS to calculate distances
            while (!queue.isEmpty()) {
                int[] cell = queue.poll();
                int x = cell[0];
                int y = cell[1];
                for (int[] dir : directions) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (nx >= 0 && nx < rows && ny >= 0 && ny < cols) {
                        if (distances[nx][ny] > distances[x][y] + 1) {
                            distances[nx][ny] = distances[x][y] + 1;
                            queue.offer(new int[] { nx, ny });
                        }
                    }
                }
            }

            return distances;
        }
    }
}


