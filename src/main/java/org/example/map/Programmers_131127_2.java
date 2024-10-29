package org.example.map;

import java.util.HashMap;
import java.util.Map;

public class Programmers_131127_2 {

    public static void main(String[] args) {
        Programmers_131127_2 sol = new Programmers_131127_2();
        String [] want = {"banana", "apple", "rice", "pork", "pot"};
        int [] numbers = {3, 2, 2, 2, 1};
        String [] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        System.out.println(sol.solution(want, numbers, discount));;
    }

    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> wantMap = new HashMap<>();

        int result = 0;
        int max = discount.length - 10;

        for(int i = 0; i < want.length; i++){
            wantMap.put(want[i], number[i]);
        }

        for(int i = 0; i <= max; i++){
            Map<String, Integer> discountMap = new HashMap<>();

            for(int j = i; j < i + 10; j++){
                String ele = discount[j];
                discountMap.put(ele, discountMap.getOrDefault(ele, 0) + 1);
            }

            if(wantMap.equals(discountMap)){
                result++;
            }
        }

        return result;
    }

}
