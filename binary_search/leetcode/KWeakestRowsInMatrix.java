package com.company.binary_search.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/description/?envType=daily-question&envId=2023-09-18
public class KWeakestRowsInMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] weakest = new int[mat.length];
        for(int i = 0; i < mat.length; i++) {
            weakest[i] = numberOfSolders(mat[i]) * 1000 + i;
        }
        Arrays.sort(weakest);
        int[] result = new int[k];
        for(int i = 0; i < k; i++) {
            result[i] = weakest[i] % 1000;
        }
        return result;
    }

    private int numberOfSolders(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while(start <= end) {
            int mid = (end - start) / 2 + start;
            if(arr[mid] == 1) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

}
