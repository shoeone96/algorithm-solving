package org.example.string;

import java.util.*;

public class leet_49 {

    public static void main(String[] args) {
        var hi = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(hi));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> stock = new HashMap<>();
        for (String ele : strs) {
            char[] arr = ele.toCharArray();
            Arrays.sort(arr);
            String sorted = String.valueOf(arr);
            if (!stock.containsKey(sorted)) {
                stock.put(sorted, new ArrayList<>());
            }
            stock.get(sorted).add(ele);

        }
        return new ArrayList<>(stock.values());
    }
}
