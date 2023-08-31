package com.adil.ds_algo.arrays.easy;

/**
 * int[] ar = { 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1 };
 * output : {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}
 */
public class Sort01 {
    public void sort(int[] arr) {
        int low = 0, mid = 0;
        while(mid < arr.length) {
            if(arr[mid] == 0) swap(arr, low++, mid++);
            else mid++;
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
