package com.adil.ds_algo.arrays.general.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * url: leetcode.com/problems/spiral-matrix/
 */

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int rowBegin = 0, rowEnd = matrix.length-1;
        int colBegin = 0, colEnd = matrix[0].length-1;

        while(rowBegin <= rowEnd && colBegin <= colEnd) {
            // traverse right
            for(int j = colBegin; j <= colEnd; j++)
                ans.add(matrix[rowBegin][j]);
            rowBegin++;

            // traverse down
            for(int i = rowBegin; i <= rowEnd; i++)
                ans.add(matrix[i][colEnd]);
            colEnd--;

            // we are adding sanity checks for right to left and bottom to top movement as we have
            // updated rowBegin and colEnd values above

            // traverse left
            if(rowBegin <= rowEnd) {
                for(int j = colEnd; j >= colBegin; j--)
                    ans.add(matrix[rowEnd][j]);
                rowEnd--;
            }

            // traverse up
            if(colBegin <= colEnd) {
                for(int i = rowEnd; i >= rowBegin; i--)
                    ans.add(matrix[i][colBegin]);
                colBegin++;
            }
        }

        return ans;
    }

}
