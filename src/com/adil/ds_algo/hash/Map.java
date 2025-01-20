package com.adil.ds_algo.hash;

public class Map {

    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("India", 190);
        map.put("China", 180);
        map.put("US", 60);

        System.out.println(map.remove("India"));
    }

}
