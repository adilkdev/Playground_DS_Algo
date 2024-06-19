package com.adil.ds_algo.recursion;

public class RecursionGeneral {

    public static void main(String[] args) {
        System.out.println();
    }

    private static void print(int n) {
        System.out.println(n + "");
        if(n > 1) print(n-1);
    }

    private static int factorial(int n) {
        if(n == 0) return 1;
        return n * factorial(n-1);
    }

    private static int sumOfDigits(int n) {
        if(n == 0) return 0;
        return (n % 10) + sumOfDigits(n/10);
    }

    private static void multiples(int n, int k) {
        if(k == 1) {
            System.out.println(n);
            return;
        }
        multiples(n, k-1);
        System.out.println(n*k);
    }

    private static int max(int[] arr, int i) {
        if(i == arr.length) return Integer.MIN_VALUE;
        if(arr[i] > max(arr, i+1)) return arr[i];
        else return max(arr, i+1);
    }

    private static String reverse(String str, int index) {
        if(index == str.length()) return "";
        return reverse(str, index+1) + str.charAt(index);
    }

}
