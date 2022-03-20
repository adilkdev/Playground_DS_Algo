package com.adil.ds_algo.arrays.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it
 *
 * Input: numRows = 5
 * Output: [
                     [1],
                    [1,1],
                   [1,2,1],
                  [1,3,3,1],
                 [1,4,6,4,1]
 *         ]
 */

/**
 *  At every row first and last elements always remains 1, so no need to compute it.
 *  Elements change as go to triangle[row-1][col-1] + triangle[row-1][col]
 */

class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> triangle = new ArrayList();
        List<Integer> row = null, prev = null;

        for(int i=0; i<numRows; i++) {
            row = new ArrayList();
            for(int j=0; j<=i; j++)
                if(j==0 || j==i)
                    row.add(1);
                else
                    row.add(prev.get(j-1) + prev.get(j));

            prev = row;
            triangle.add(row);
        }
        return triangle;
    }

}
