package com.adil.ds_algo.dynamicProgramming;

/**
 * <a href="https://leetcode.com/problems/longest-palindromic-substring/">...</a>
 */

class LongestPalindromicSubstring {

    /**
     * two pointer approach
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        int start = 0, end = 0;

        for(int i = 0; i < n; i++) {
            int odd = expand(s, i, i);
            int even = expand(s, i, i + 1);
            int len = Math.max(odd, even);
            if(len > end - start + 1) {
                start = i - (len-1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }


    int expand(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    /**
     * dp
     */
    public String longestPalindromeDP(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        String ans = "";
        int len = 0;

        for(int diff = 0; diff < n; diff++) {
            for(int i = 0, j = diff; j < n; i++, j++) {
                if(i == j)
                    dp[i][j] = 1;
                else if(diff == 1)
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? 2 : 0;
                else if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] > 0)
                    dp[i][j] = 2 + dp[i+1][j-1];

                if(dp[i][j] > 0) {
                    if(j-i+1 > len) {
                        len = j-i+1;
                        ans = s.substring(i, j+1);
                    }
                }
            }
        }

        return ans;
    }
}
