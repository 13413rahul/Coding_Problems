package com.company.dfs.gfg;

// https://practice.geeksforgeeks.org/problems/number-of-enclaves/1
public class NOOfEnclaves {
    int numberOfEnclaves(int[][] grid) {

        // Your code here

        n=grid.length;
        m=grid[0].length;

        boolean[][] vis=new boolean[n][m];


        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if((i==0 || j==0 || i==n-1 || j==m-1) && vis[i][j]==false && grid[i][j]==1)
                {
                    DFS(i,j,vis,grid);
                }
            }
        }

        int res=0;


        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(vis[i][j]==false && grid[i][j]==1)
                {
                    res++;
                }
            }
        }

        return res;


    }

    public static int n;
    public static int m;

    public static void DFS(int i,int j,boolean[][] vis,int[][] grid)
    {

        vis[i][j]=true;


        if(i+1<n && grid[i+1][j]==1 && vis[i+1][j]==false)
        {
            DFS(i+1,j,vis,grid);
        }

        if(j+1<m && grid[i][j+1]==1 && vis[i][j+1]==false)
        {
            DFS(i,j+1,vis,grid);
        }

        if(i-1>=0 && grid[i-1][j]==1 && vis[i-1][j]==false)
        {
            DFS(i-1,j,vis,grid);
        }

        if(j-1>=0 && grid[i][j-1]==1 && vis[i][j-1]==false)
        {
            DFS(i,j-1,vis,grid);
        }


    }
}
