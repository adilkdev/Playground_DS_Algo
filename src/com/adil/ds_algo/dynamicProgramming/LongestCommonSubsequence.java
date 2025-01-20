package com.adil.ds_algo.dynamicProgramming;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/longest-common-subsequence/">...</a>
 */

class LongestCommonSubsequence {

    public static void main(String[] args) {

    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m][n];
        for(int[] arr: dp)
            Arrays.fill(arr, -1);
        return lcs(text1, text2, text1.length()-1, text2.length()-1, dp);
    }

    /**
     * top-down approach
     */

    public int lcs(String s1, String s2, int i, int j, int[][] dp) {
        if(i < 0 || j < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = 1 + lcs(s1, s2, i - 1, j - 1, dp);

        return dp[i][j] = Math.max(lcs(s1, s2, i-1, j, dp), lcs(s1, s2, i, j-1, dp));
    }

    /**
     * tabulation method bottom up
     * we need shifting of index because we can't have dp[-1], so we consider n+1 in dp size
     */
    public int lcsTab(String s1, String s2, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int[] arr: dp)
            Arrays.fill(arr, -1);
        for(int i = 0; i <= m; i++)
            dp[i][0] = 0;
        for(int i = 0; i <= n; i++)
            dp[0][i] = 0;

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m][n];
    }

    public int lcsTabOptim(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[] prev = new int[n+1];
        int[] cur = new int[n+1];

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(s1.charAt(j-1) == s2.charAt(i-1))
                    cur[j] = 1 + prev[j-1];
                else
                    cur[j] = Math.max(prev[j], cur[j-1]);
            }
            for(int x = 0; x <= m; x++)
                prev[x] = cur[x];
        }
        return prev[m];
    }

}
