package org.example.map;

import java.util.HashMap;
import java.util.Map;

public class Programmers_42576 {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> particeMap = new HashMap<>();
        for(String mem : participant){
            particeMap.put(mem, particeMap.getOrDefault(mem, 0) + 1);
        }
        for(String complete: completion){
            particeMap.put(complete, particeMap.get(complete) -1);
        }
        for(String mem: particeMap.keySet()){
            if(particeMap.get(mem) == 1){
                return mem;
            }
        }
        return "";
    }
}
