package com.company.Array.gfg;

// https://practice.geeksforgeeks.org/problems/boolean-matrix-problem-1587115620/1
public class SetMatrixOnes {
    //Function to modify the matrix such that if a matrix cell matrix[i][j]
    //is 1 then all the cells in its ith row and jth column will become 1.
    void booleanMatrix(int matrix[][]){

        int r = matrix.length;
        int c = matrix[0].length;

        //auxilary space
        boolean row [] = new boolean [r];
        boolean col [] = new boolean [c];

        for(int a=0; a<r; a++) {        // row length
            for(int b=0; b<c; b++){    // col length
                if(matrix[a][b] == 1){ // agar matrix a,b ma 1 hai toh
                    row[a] = true;    //row true;
                    col[b] = true;   // col true
                }
            }
        }

        for(int a=0; a<r; a++) {       // row length
            for(int b=0; b<c; b++){   // col length
                if(row[a] ==  true || col[b] == true){ // agar row[a] or col [b]  true hai toh
                    matrix[a][b] =1; // matrix a and b ma 1 store kar
                }
            }
        }

    }
}
