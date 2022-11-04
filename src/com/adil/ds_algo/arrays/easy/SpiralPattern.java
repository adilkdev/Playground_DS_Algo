package com.adil.ds_algo.arrays.easy;

public class SpiralPattern {

    public static void main(String ar[]) {
//        int arr[][] = {
//                {11, 12, 13, 14, 15},
//                {24, 25, 26, 27, 16},
//                {23, 30, 29, 28, 17},
//                {22, 21, 20, 19, 18}
//        };

        int arr[][] = {
                {11, 12, 13, 14, 15, 16, 17},
                {21, 22, 23, 24, 25, 26, 27},
                {31, 32, 33, 34, 35, 36, 37},
                {41, 42, 43, 44, 45, 46, 47},
                {51, 52, 53, 54, 55, 56, 57}
        };

        int rows = arr.length, cols = arr[0].length;
        int minRow = 0, minCol = 0, maxRow = rows - 1, maxCol = cols - 1;
        int count = 0;

        while (count < rows * cols) {

            for (int j = minCol; j <= maxCol && count < rows * cols; j++) {
                System.out.print(arr[minRow][j] + ", ");
                count++;
            }
            minRow++;

            for (int i = minRow; i <= maxRow && count < rows * cols; i++) {
                System.out.print(arr[i][maxCol] + ", ");
                count++;
            }
            maxCol--;

            for (int j = maxCol; j >= minCol && count < rows * cols; j--) {
                System.out.print(arr[maxRow][j] + ", ");
                count++;
            }
            maxRow--;

            for (int i = maxRow; i >= minRow && count < rows * cols; i--) {
                System.out.print(arr[i][minCol] + ", ");
                count++;
            }
            minCol++;

            System.out.println(" ");
        }
    }

}
