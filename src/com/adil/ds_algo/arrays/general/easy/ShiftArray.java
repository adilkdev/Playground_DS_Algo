package com.adil.ds_algo.arrays.general.easy;

public class ShiftArray {

    public static void main(String ar[]) {
        int arr[] = {3, 5, 6, 7};

        shiftLeft(arr);
        printArray(arr);
    }

    /**
     * Shifting array left or right by a single element.
     */

    public static void shiftLeft(int arr[]) {
        int n = arr.length;
        int i = 0;
        int temp = arr[0];
        while(i<n-1) {
            arr[i] = arr[i+1];
            i++;
        }
        arr[n-1] = temp;
    }

    public static void shiftRight(int arr[]) {
        int n = arr.length;
        int i = n-2;
        int temp = arr[n-1];
        while(i>=0) {
            arr[i+1] = arr[i];
            i--;
        }
        arr[0] = temp;
    }

    public static void printArray(int arr[]) {
        for(int element : arr) {
            System.out.print(" " + element);
        }
    }

}
