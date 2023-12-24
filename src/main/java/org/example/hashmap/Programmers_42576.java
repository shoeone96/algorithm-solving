package org.example.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Programmers_42576 {

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> particeMap = new HashMap<>();
        for (String runner : participant) {
            particeMap.put(runner, particeMap.getOrDefault(runner, 0) + 1);
        }
        for (String player : completion){
            particeMap.put(player, particeMap.get(player) - 1);
        }
        Set<String> keySet = particeMap.keySet();
        for(String key : keySet){
            if(particeMap.get(key) == 1){
                answer = key;
            }
        }
        return answer;
    }

}
