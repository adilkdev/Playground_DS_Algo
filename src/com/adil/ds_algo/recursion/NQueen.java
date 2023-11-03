package com.adil.ds_algo.recursion;

public class NQueen {

    public int totalNQueens(int n) {
        Integer res = 0;
        int[][] board = new int[n][n];
        System.out.println("res = " + nQueen(board, n, 0));
        return res;
    }

    public boolean nQueen(int[][] board, int n, int row) {
        if(row == n) {
            return true;
        }

        for(int col = 0; col < n; col++) {
            if(isSafe(board, n, row, col)) {
                board[row][col] = 1;
                if(nQueen(board, n, row+1)) {
                    return true;
                }
                board[row][col] = 0;
            }
        }
        return false;
    }

    public boolean isSafe(int[][] board, int n, int row, int col) {
        // check for column
        for(int i = 0; i < n; i++)
            if(board[i][col] == 1) return false;

        // check for upper left diagonal
        for(int i = row, j = col; i >= 0 && j >=0; i--, j--)
            if(board[i][j] == 1) return false;

        // check for upper right diagonal
        for(int i = row, j = col; i >= 0 && j < n; i--, j++)
            if(board[i][j] == 1) return false;

        return true;
    }

}
