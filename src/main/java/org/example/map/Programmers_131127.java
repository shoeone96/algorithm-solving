package org.example.map;

import java.util.HashMap;
import java.util.Map;

public class Programmers_131127 {

    public static void main(String[] args) {
        Programmers_131127 sol = new Programmers_131127();
        String [] want = {"apple"};
        int [] numbers = {10};
        String [] discount = {"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"};
        System.out.println(sol.solution(want, numbers, discount));;
    }

    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> wantMap = new HashMap<>();

        int result = 0;
        int max = discount.length - 10;

        for(int i = 0; i <= max; i++){
            for(int k = 0; k < want.length; k++){
                wantMap.put(want[k], number[k]);
            }

            for(int j = i; j < i + 10; j++){
                String ele = discount[j];
                if(wantMap.containsKey(ele)){
                    wantMap.put(ele, wantMap.get(ele) - 1);
                }
            }

            boolean isFinished = true;
            for(String key : wantMap.keySet()){
                if(wantMap.get(key) != 0){
                    isFinished = false;
                }
            }

            if (isFinished) {
                result++;
            }
        }

        return result;
    }

}
