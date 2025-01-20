package com.adil.ds_algo.arrays.general.medium;

/**
 * Given an m x n integer matrix, if an element is 0, set its entire row and column to 0's.
 * You must do it in place.
 * Input: matrix = [
 *                      [1,1,1],
 *                      [1,0,1],
 *                      [1,1,1]
 *                 ]
 * Output:         [
 *                      [1,0,1],
 *                      [0,0,0],
 *                      [1,0,1]
 *                 ]
 */

class SetMatrixZeros {

    public void setZeroes(int[][] matrix) {
        /**
         * n = number of rows
         * m = number of columns
         */
        int n = matrix.length;
        int m = matrix[0].length;

        /**
         * if zeroth row or column has any 0
         */
        boolean firstRow=false, firstCol=false;

        /**
         * if zeroth row or column has any 0 then make the corresponding variable true.
         */
        for(int i=0; i<n; i++)
            if (matrix[i][0] == 0) {
                firstRow = true;
                break;
            }
        for(int j=0; j<m; j++)
            if (matrix[0][j] == 0) {
                firstCol = true;
                break;
            }

        /**
         * if the matrix contains zero, make the 0th element of row and column = 0
         * here we are saving the rows and columns which are needed to be made 0
         */

        for(int i=1; i<n; i++)
            for(int j=1; j<m; j++)
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }

        /**
         * looping the rows and making the complete row = 0 if required
         */

        for(int i=1; i<n; i++)
            if(matrix[i][0] == 0)
                for(int j=1; j<m; j++)
                    matrix[i][j] = 0;

        /**
         * looping the columns and making the complete column = 0 if required
         */

        for(int j=1; j<m; j++)
            if(matrix[0][j] == 0)
                for(int i=1; i<n; i++)
                    matrix[i][j] = 0;

        /**
         * if row = true, we'll make all the 0th element of rows = 0
         */

        if(firstRow) {
            for(int i=0; i<n; i++)
                matrix[i][0] = 0;
        }

        /**
         * if col = true, we'll make all the 0th element of columns = 0
         */

        if(firstCol) {
            for(int j=0; j<m; j++)
                matrix[0][j] = 0;
        }

    }


}
