package com.adil.ds_algo.arrays.medium;

/**
 * https://leetcode.com/problems/unique-paths/submissions/
 * solution : https://www.youtube.com/watch?v=t_f0nwwdg5o
 */

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int arr[][] = new int[m][n];
        for(int i=0; i<arr.length; i++)
            for(int j=0; j<arr[i].length; j++)
                arr[i][j] = -1;

        return countPaths(0, 0, m, n, arr);
    }

    public int countPaths(int i, int j, int m, int n, int arr[][]) {
        if (i == m-1 && j == n-1) return 1;
        else if (i>=m || j>=n) return 0;
        if (arr[i][j] != -1) return arr[i][j];
        else return arr[i][j] = countPaths(i+1,j, m, n, arr) + countPaths(i,j+1, m, n, arr);
    }

}
