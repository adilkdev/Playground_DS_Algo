package com.adil.ds_algo.arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6]
 */

class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1)
            return intervals;

        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));

        List<int []> outputList = new ArrayList();
        int[] currentInterval = intervals[0];
        outputList.add(currentInterval);

        for(int[] interval : intervals) {
            int currentBegin = currentInterval[0];
            int currentEnd = currentInterval[1];
            int nextBegin = interval[0];
            int nextEnd = interval[1];

            if (currentEnd >= nextBegin) {
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                currentInterval = interval;
                outputList.add(currentInterval);
            }
        }

        return outputList.toArray(new int[outputList.size()][]);
    }
}