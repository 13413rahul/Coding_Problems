package com.company.Array.gfg;

import java.util.ArrayList;

// https://practice.geeksforgeeks.org/problems/boundary-traversal-of-matrix-1587115620/1
public class BoundaryTraversalOfMatrix {
    //Function to return list of integers that form the boundary
    //traversal of the matrix in a clockwise manner.
    static ArrayList<Integer> boundaryTraversal(int matrix[][], int n, int m)
    {

        ArrayList<Integer> list =new ArrayList<>();

        if(m==1){
            for(int i=0;i<n;i++){


                list.add(matrix[i][0]);
            }
            return list;
        }


        if(n==1){
            for(int i=0;i<m;i++){
                list.add(matrix[0][i]);
            }
            return list;
        }

        // code here
        for(int i=0;i<m;i++){
            list.add(matrix[0][i]);
        }

        for(int i=1;i<n;i++){
            list.add(matrix[i][m-1]);
        }

        for(int i=m-2;i>=0;i--){
            list.add(matrix[n-1][i]);
        }

        for(int i=n-2;i>0;i--){
            list.add(matrix[i][0]);
        }

        return list;
    }
}
