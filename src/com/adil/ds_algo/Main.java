package com.adil.ds_algo;
import com.adil.ds_algo.stack.easy.NextGreaterElement;
import com.adil.ds_algo.stack.easy.NextSmallerElement;
import com.adil.ds_algo.stack.easy.PreviousSmallerElement;

public class Main {

    public static void main(String[] args) {
//        MoveAllZerosToEnd move = new MoveAllZerosToEnd();
//        int[] result = move.moveZeroes(new int[]{0,1,0,-3,12});
//        Arrays.stream(result).forEach(System.out::println);

//        int[] a = {1, 10, 7, 4, 9, 0 , 9, 9};
//        QuickSort sort = new QuickSort();
//        sort.quicksort(a, 0, a.length - 1);
//        Arrays.stream(a).forEach(System.out::println);
        NextGreaterElement nge = new NextGreaterElement();
        nge.previousSmallerElement(new int[]{2, 10, 12, 1, 11});
    }

}
