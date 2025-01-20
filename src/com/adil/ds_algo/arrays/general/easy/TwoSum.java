package com.adil.ds_algo.arrays.general.easy;

import java.util.*;


/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1]
 */

public class TwoSum {

    /**
     * TC -> O(nlogn) solution
     * SC -> O(n)
     */

    class Pair {
        int index;
        int value;

        public Pair(int index, int value)
        {
            this.index = index;
            this.value = value;
        }
    }

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        /**
         * created array of custom objects
         */
        Pair[] pairArr = new Pair[n];

        for(int i=0; i<n; i++)
            pairArr[i] = new Pair(i, nums[i]);

        /**
         * Sorting my custom array using comparator
         */
        Arrays.sort(pairArr, new Comparator<Pair>() {
            @Override public int compare(Pair p1, Pair p2)
            {
                return p1.value - p2.value;
            }
        });

        int start = 0;
        int end = nums.length-1;
        int[] ans = new int[2];

        while(start<end) {
            if((pairArr[start].value + pairArr[end].value) == target) {
                ans[0] = pairArr[start].index;
                ans[1] = pairArr[end].index;
                break;
            } else if((pairArr[start].value + pairArr[end].value) > target) {
                end--;
            } else {
                start++;
            }
        }
        return ans;
    }

/**
 ******************************************************************************************************
 *******************************************************************************************************
 */


    /**
     * TC -> O(n) solution using hashmap
     * SC -> O(n)
     */
    public int[] twoSumOptimised(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int reqNo = target - numbers[i];
            if (map.containsKey(reqNo)) {
                result[1] = i;
                result[0] = map.get(reqNo);
                return result;
            }
            map.put(numbers[i], i);
        }
        return result;
    }

}
