package com.adil.ds_algo.recursion;

import java.util.ArrayList;
import java.util.List;

class PalindromePartition {

    public static void main(String[] args) {
        for (List<String> list: partition("aab")) {
            for (String s: list)
                System.out.print(s+ ", ");
            System.out.println(" ");
        }
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        util(s, 0, res, new ArrayList<>());
        return res;
    }

    public static void util(String s, int index, List<List<String>> res, List<String>ds) {
        if(index == s.length()) {
            res.add(new ArrayList<>(ds));
            return;
        }
        for(int i = index; i < s.length(); i++) {
            if(isPalindrome(s, index, i)) {
                ds.add(s.substring(index, i+1));
                util(s, i+1, res, ds);
                ds.remove(ds.size()-1);
            }
        }
    }

    public static boolean isPalindrome(String s, int start, int end) {
        System.out.println(s.substring(start, end+1));
        while(start <= end) {
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}
