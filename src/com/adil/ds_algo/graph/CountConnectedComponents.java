package com.adil.ds_algo.graph;

import java.util.LinkedList;
import java.util.Queue;

public class CountConnectedComponents {

    public static void main(String[] args) {
        int[][] edges = {
                {0,1}, {1,2}, {2,3}, {3,0}, {4,5}, {6,7}, {7,4}, {8,9}, {10,11}
        };
        int n = 12;

        int[][] graph = new int[n][n];
        for(int i = 0; i < edges.length; i++) {
            graph[edges[i][0]][edges[i][1]] = 1;
            graph[edges[i][1]][edges[i][0]] = 1;
        }
        System.out.println(countComponents(n, graph));
    }

    public static int countComponents(int n, int[][] graph) {
        int components = 0;
        boolean[] vis = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                components++;
                bfs(graph, vis, i);
            }
        }
        return components;
    }

    public static void bfs(int[][] graph, boolean[] vis, int src) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        vis[src] = true;

        while(!q.isEmpty()) {
            int u = q.poll();
            for(int i = 0; i < graph[0].length; i++) {
                if(graph[u][i] == 1 && !vis[i]) {
                    q.offer(i);
                    vis[i] = true;
                }
            }
        }
    }

}
