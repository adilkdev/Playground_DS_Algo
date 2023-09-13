package com.adil.ds_algo.arrays.easy.sorting;

/**
 * input : {1, 10, 7, 4, 9, 0 , 9, 9};
 * Output : {0, 1, 4, 7, 9, 9, 9, 10}
 */
public class QuickSort {

    public void quicksort(int[] a, int p, int r) {
        if (p < r) {
            int q = partition(a, p, r);
            quicksort(a, p, q - 1);
            quicksort(a, q + 1, r);
        }
    }

    public int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (a[j] <= pivot) {
                i++;
                swap(a, i, j);
            }
        }

        swap(a, i + 1, r);
        return i + 1;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
