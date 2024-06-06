package com.adil.ds_algo.recursion;

import java.util.ArrayList;

public class SubsequencesOfString {

    public static void main(String ar[]) {
        System.out.println(getSubsequences("abc"));
    }

    private static ArrayList<String> getSubsequences(String s) {
        ArrayList<String> ans = new ArrayList<>();
        if(s.isEmpty()) {
            ans.add("");
            return ans;
        }
        char currChar = s.charAt(0);
        ArrayList<String> subAns = getSubsequences(s.substring(1));
        for(String str: subAns) {
            ans.add(str);
            ans.add(currChar + str);
        }
        return ans;
    }

}
