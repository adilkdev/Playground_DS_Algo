package com.adil.ds_algo.arrays.general.medium;

/**
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise)
 * Input: matrix = [
 *      [1,2,3],
 *      [4,5,6],
 *      [7,8,9]
 * ]
 * Output: [
 *      [7,4,1],
 *      [8,5,2],
 *      [9,6,3]
 * ]
 */

public class Rotate2dMatrix {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int i, j, temp;

        // Step 1 : convert the given matrix to its transpose
        for (i = 0; i < n; i++) {
            for (j = i; j < n; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2 : reverse the columns of the transpose matrix
        for (i = 0; i < n; i++)
            for (j = 0; j < n / 2; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }

    }

}
