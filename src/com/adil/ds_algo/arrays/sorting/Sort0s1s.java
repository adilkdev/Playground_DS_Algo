package com.adil.ds_algo.arrays.sorting;

public class Sort0s1s {

    public void sort(int[] arr) {
        int n = arr.length;
        int left = 0, right = n - 1;
        while(left < right) {
            if(arr[left] == 1 && arr[right] == 1) {
                swap(arr, left, right);
                left++; right--;
            }
            if (arr[left] == 0) left++;
            if (arr[right] == 1) right--;
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
