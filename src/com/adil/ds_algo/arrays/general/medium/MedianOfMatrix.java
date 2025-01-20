package com.adil.ds_algo.arrays.general.medium;

/**
 * Testcases
 *         int[][] a = {
 *                 {1, 3, 5},
 *                 {9, 7, 9},
 *                 {8, 6, 9}
 *         };
 *         int[][] a = {{1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3}};
 *         int[][] a = {{39, 39, 39, 6292, 6292, 6292, 6292, 7002, 7002, 7002, 7002}};
 */
public class MedianOfMatrix {

    int[][] a = {
            {1, 3, 4},
            {2, 6, 9},
            {3, 6, 9}
    };

    public int findMedian(int[][] A) {
        int l = Integer.MAX_VALUE, r = Integer.MIN_VALUE, totalCount = 0, ans = -1;
        for (int[] arr : A) {
            l = Math.min(l, arr[0]);
            r = Math.max(r, arr[arr.length - 1]);
            totalCount += arr.length;
        }

        while(l <= r) {
            int tempMedian = l + (r - l) / 2;
            int count = 0;
            for (int[] a : A)
                count += countOfSmallerElements(a, tempMedian);
            System.out.println(count);
            if(count <= totalCount/2) {
                l = tempMedian + 1;
                ans = tempMedian;
            } else {
                r = tempMedian - 1;
            }
        }

        return ans;
    }

    public int countOfSmallerElements(int[] a, int median) {
        int l = 0, r = a.length - 1;
        while(l <= r) {
            int m = l + (r-l)/2;
            if (a[m] < median){
                l = m + 1;
            } else
                r = m - 1;
        }
        return l;
    }

    public int binarySearch(int[] a, int key) {
        int l = 0, r = a.length-1;
        while(l <= r) {
            int mid = l + (r-l) / 2;
            if(a[mid] <= key) {
                l = mid + 1;
            } else if(key < a[mid]) {
                r = mid - 1;
            } else
                l = mid + 1;
        }
        return l;
    }
}

