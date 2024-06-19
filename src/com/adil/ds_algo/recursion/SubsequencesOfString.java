package com.adil.ds_algo.recursion;

import com.adil.ds_algo.A;

import java.util.ArrayList;

public class SubsequencesOfString {

    public static void main(String[] ar) {
        ArrayList<String> res = new ArrayList<>();
        getSS("abc", "", res);
        System.out.println(res);
    }

    private static void getSS(String s, String currAns, ArrayList<String> list) {
        if (s.isEmpty()) {
            list.add(currAns);
            return;
        }

        char curr = s.charAt(0);
        String rem = s.substring(1);
        getSS(rem, currAns + curr, list);
        getSS(rem, currAns, list);
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

    private static ArrayList<String> getSubsequencesWithIndex(String s, int index) {
        ArrayList<String> ans = new ArrayList<>();
        if(index == s.length()) {
            ans.add("");
            return ans;
        }
        char currChar = s.charAt(index);
        ArrayList<String> subAns = getSubsequencesWithIndex(s, index+1);
        for(String str: subAns) {
            ans.add(str);
            ans.add(currChar + str);
        }
        return ans;
    }

}
