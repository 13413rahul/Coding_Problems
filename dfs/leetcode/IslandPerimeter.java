package com.company.dfs.leetcode;

// https://leetcode.com/problems/island-perimeter/
public class IslandPerimeter {
    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        Solution solution  = new Solution();
        int perimeter = solution.islandPerimeter(grid);
        System.out.println(perimeter);
    }

    static public class Solution {
        public int islandPerimeter(int[][] grid) {
            if (grid == null) return 0;
            for (int i = 0 ; i < grid.length ; i++){
                for (int j = 0 ; j < grid[0].length ; j++){
                    if (grid[i][j] == 1) {
                        return getPerimeter(grid, i, j);
                    }
                }
            }
            return 0;
        }

        public int getPerimeter(int[][] grid, int i, int j){
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {return 1;}

            if (grid[i][j] == 0) {
                return 1;
            }

            if (grid[i][j] == -1) return 0;

            int count = 0;
            grid[i][j] = -1;

            count += getPerimeter(grid, i - 1, j);
            count += getPerimeter(grid, i, j - 1);
            count += getPerimeter(grid, i, j + 1);
            count += getPerimeter(grid, i + 1, j);

            return count;

        }
    }
}
