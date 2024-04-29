package com.adil.ds_algo.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathDfs {

    public static void main(String[] ar) {
        int[][] edges = {
                new int[]{1,5},
                new int[]{1,6},
                new int[]{2,0},
                new int[]{3,3},
                new int[]{4,0},
                new int[]{4,6},
                new int[]{5,3},
                new int[]{5,4},
                new int[]{6,5},
                new int[]{6,6}
        };
        int[] d = shortestPath(edges, 7, 10, 4);
        System.out.println(" ");
        for(int r = 0; r < d.length; r++) {
            System.out.print(r + ", ");
        }
    }

    public static int[] shortestPath(int[][] edges,int n,int m ,int src) {
        boolean[] vis = new boolean[n];
        int [] dis = new int[n];
        Arrays.fill(dis, -1);

        int[][] adj = new int[n][n];
        for(int[] r: edges) {
            adj[r[0]][r[1]] = 1;
        }

        dfs(src, adj, vis, dis);

        return dis;
    }

    private static void dfs(int v, int[][] adj, boolean[] vis, int[] dis) {
        vis[v] = true;
        for(int e: adj[v]) {
            if(!vis[e]) {
                if(dis[e] > dis[v] + 1) dis[e] = dis[v] + 1;
                dfs(e, adj, vis, dis);
            }
        }
    }

}

