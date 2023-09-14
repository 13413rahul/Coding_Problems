package com.company.binary_search.leetcode;

/**
 * This class provides a solution for counting the number of negative elements in a 2D grid.
 */
// https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/description/
public class CountNegativeNoInMatrix {

    /**
     * Counts the number of negative elements in the given grid.
     *
     * @param grid The 2D grid of integers
     * @return The count of negative elements in the grid
     */
    public int countNegatives(int[][] grid) {
        // Get the number of rows and columns in the grid
        int m = grid.length;
        int n = grid[0].length;
        // Initialize the count of negative elements
        int count = 0;

        // Iterate over each row in the grid
        for (int i = 0; i < m; i++) {
            // Count the number of negative elements in the current row
            count += (n - bs(grid[i]));
        }

        // Return the total count of negative elements in the grid
        return count;
    }

    /**
     * Performs binary search on the given array to find the index of the first negative element.
     *
     * @param arr The input array
     * @return The index of the first negative element or the leftmost index of the array if no negative element is found
     */
    public int bs(int arr[]) {
        // Initialize the left and right pointers for binary search
        int left = 0;
        int right = arr.length - 1;

        // Perform binary search until the left and right pointers meet
        while (left <= right) {
            // Calculate the middle index
            int mid = left + (right - left) / 2;

            // If the middle element is negative, search in the left half
            if (arr[mid] < 0) {
                right = mid - 1;
            }
            // If the middle element is non-negative, search in the right half
            else {
                left = mid + 1;
            }
        }

        // Return the left pointer as the index of the first negative element
        return left;
    }
}