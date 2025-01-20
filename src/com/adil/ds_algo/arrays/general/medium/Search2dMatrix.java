package com.adil.ds_algo.arrays.general.medium;

/**
 * https://leetcode.com/problems/search-a-2d-matrix/submissions/
 * Solution : https://www.youtube.com/watch?v=eT0UqrYuqbg
 */

public class Search2dMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows*cols-1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            int midElement = matrix[mid/cols][mid%cols];
            if (midElement < target) {
                left = mid + 1;
            } else if (midElement == target) {
                return true;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

}
