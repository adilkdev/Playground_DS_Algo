package com.adil.ds_algo.arrays.general.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * int[] nums1 = {1, 2, 2, 3, 5, 5 ,5 ,5};
 * int[] nums2 = {2, 3, 3, 4};
 * output : {1, 2, 3, 4, 5}
 */
public class UnionOfTwoSortedArray {

    public List<Integer> union(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        ArrayList<Integer> list = new ArrayList<>();

        while(i < n1 && j < n2) {

            if (i > 0 && nums1[i] == nums1[i - 1]) {
                i++;
                continue;
            }

            if (j > 0 && nums2[j] == nums2[j - 1]) {
                j++;
                continue;
            }

            if(nums1[i] < nums2[j]) {
                list.add(nums1[i++]);
            } else if(nums1[i] == nums2[j]) {
                list.add(nums1[i++]);
                j++;
            } else {
                list.add(nums2[j++]);
            }
        }

        while(i < n1) {
            if (i > 0 && nums1[i] == nums1[i - 1]) {
                i++;
                continue;
            }
            list.add(nums1[i++]);
        }

        while(j < n2) {
            if (j > 0 && nums2[j] == nums2[j - 1]) {
                j++;
                continue;
            }
            list.add(nums2[j++]);
        }

        return list;
    }
}
