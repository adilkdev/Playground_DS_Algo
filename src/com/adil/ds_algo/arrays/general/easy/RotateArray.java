package com.adil.ds_algo.arrays.general.easy;

import static com.adil.ds_algo.arrays.general.easy.ShiftArray.printArray;

public class RotateArray {

    public static void main(String ar[]) {
        int arr[] = {3, 5, 6, 7};
        int k = 2;
        int n = arr.length;

        reverse(arr,0,arr.length-1);
        reverse(arr, 0, k-1);
        reverse(arr, k, n-1);
        printArray(arr);
    }

    public static void reverse(int arr[], int start, int end) {
        while (start < end){
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    public static void swap(int arr[], int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

}
