package com.adil.ds_algo.arrays.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/majority-element-ii/submissions/
 * solution : https://www.youtube.com/watch?v=yDbkQd9t2ig
 */

public class MajorityElement {

    public List<Integer> majorityElement(int[] nums) {
        int element1 = -1;
        int element2 = -1;
        int count1 = 0, count2 = 0;
        List<Integer> res = new ArrayList();

        for(int i=0; i<nums.length; i++) {
            if (nums[i] == element1) {
                count1++;
            } else if (nums[i] == element2) {
                count2++;
            } else if (count1 == 0) {
                count1 = 1;
                element1 = nums[i];
            } else if (count2 == 0) {
                count2 = 1;
                element2 = nums[i];
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for(int i=0; i<nums.length; i++) {
            if (nums[i] == element1)
                count1++;
            else if (nums[i] == element2)
                count2++;
        }

        if(count1 > nums.length/3)
            res.add(element1);
        if(count2 > nums.length/3)
            res.add(element2);
        return res;
    }

}
