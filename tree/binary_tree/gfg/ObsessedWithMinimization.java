package com.company.tree.binary_tree.gfg;

import java.util.ArrayList;
import java.util.Arrays;

// https://practice.geeksforgeeks.org/contest/gfg-weekly-coding-contest-123/problems
public class ObsessedWithMinimization {
    final int LG=20;
    int lvl[], P[][], pref[];
    ArrayList<Integer> l[];

    void dfs(int node, int par){
        if(par != -1){
            lvl[node] = 1 + lvl[par];
            P[node][0] = par;
        }

        for(int kid : l[node]){
            if(kid == par)
                continue;
            dfs(kid, node);
        }
    }

    void dfs2(int node, int par) {
        for (int kid : l[node]){
            if(kid == par)
                continue;
            dfs2(kid, node);
            pref[node] += pref[kid];
        }
    }

    int lca(int u, int v){
        if(lvl[u]<lvl[v]){
            int t = u; u=v; v=t;
        }

        for(int i = LG; i >= 0; i--)
            if(lvl[u] - (1<<i) >= lvl[v])
                u = P[u][i];

        if(u == v)
            return u;

        for(int i = LG;i >=0 ;i--)
            if(P[u][i] != -1 && P[u][i] != P[v][i]){
                u = P[u][i];
                v = P[v][i];
            }

        return P[u][0];
    }

    long findMin(int N, int M, int p[], int w[], int source[], int destination[]){
        lvl = new int[N + 1];
        pref = new int[N + 1];
        P = new int[N + 1][LG + 1];
        l = new ArrayList[N + 1];
        for(int i = 0; i <= N; i++) l[i] = new ArrayList<>();

        for(int i = 1; i < N; i++){
            l[p[i]].add(i);
            l[i].add(p[i]);
        }

        for(int row[] : P)
            Arrays.fill(row, -1);

        dfs(0, -1);

        for(int i = 1; i <= LG; i++){
            for(int j = 0; j < N; j++){
                if(P[j][i - 1] == -1)
                    continue;
                int x = P[j][i - 1];
                P[j][i] = P[x][i - 1];
            }
        }

        for (int i = 0; i < M; i++) {
            int u = source[i];
            int v = destination[i];

            int lc = lca(u, v);

            pref[u]++;
            pref[v]++;
            pref[lc] -= 2;
        }

        dfs2(0, -1);

        Arrays.sort(w, 1, N);
        Arrays.sort(pref, 1, N);

        long ans = 0l;
        for(int i = 1; i < N; i++){
            ans += (1L * w[i]) * (1L * pref[N - i]);
        }

        return ans;
    }
}
