package com.adil.ds_algo.arrays.general.easy;

public class SpiralPattern {

    public static void main(String ar[]) {
        int arr[][] = {
                {11, 12, 13, 14},
                {22, 23, 24, 15},
                {21, 26, 25, 16},
                {20, 19, 18, 17}
        };

//        int arr[][] = {
//                {11, 12, 13, 14, 15, 16, 17},
//                {21, 22, 23, 24, 25, 26, 27},
//                {31, 32, 33, 34, 35, 36, 37},
//                {41, 42, 43, 44, 45, 46, 47},
//                {51, 52, 53, 54, 55, 56, 57}
//        };

        int rows = arr.length, cols = arr[0].length;
        int minRow = 0, minCol = 0, maxRow = rows - 1, maxCol = cols - 1;

        while (minRow <= maxRow && minCol <= maxCol) {

            for (int j = minCol; j <= maxCol; j++) {
                System.out.print(arr[minRow][j] + ", ");
            }
            minRow++;

            for (int i = minRow; i <= maxRow; i++) {
                System.out.print(arr[i][maxCol] + ", ");
            }
            maxCol--;

            for (int j = maxCol; j >= minCol; j--) {
                System.out.print(arr[maxRow][j] + ", ");
            }
            maxRow--;

            for (int i = maxRow; i >= minRow; i--) {
                System.out.print(arr[i][minCol] + ", ");
            }
            minCol++;

            System.out.println(" ");
        }
    }

}
