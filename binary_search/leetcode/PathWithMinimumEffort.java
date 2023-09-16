package com.company.binary_search.leetcode;

// https://leetcode.com/problems/path-with-minimum-effort/?envType=daily-question&envId=2023-09-16
public class PathWithMinimumEffort {
    private final int[] DIR = {0, 1, 0, -1, 0};

    private boolean dfs(int r, int c, boolean[][] visited, int threshold, int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        if (r == m - 1 && c == n - 1) return true; // Reach destination
        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nr = r + DIR[i];
            int nc = c + DIR[i + 1];

            if (nr < 0 || nr == m || nc < 0 || nc == n || visited[nr][nc]) continue;

            if (Math.abs(heights[nr][nc] - heights[r][c]) <= threshold && dfs(nr, nc, visited, threshold, heights)) {
                return true;
            }
        }
        return false;
    }

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int left = 0;
        int ans = 0;
        int right = 1_000_000;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            boolean[][] visited = new boolean[m][n];

            if (dfs(0, 0, visited, mid, heights)) {
                right = mid - 1; // Try to find a better result on the left side
                ans = mid;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}
