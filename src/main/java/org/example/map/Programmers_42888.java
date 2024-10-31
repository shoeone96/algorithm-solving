package org.example.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Programmers_42888 {

    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        for(String ele : record){
            if(ele.startsWith("Enter")){
                String[] split = ele.split(" ");
                map.put(split[1], split[2]);
            } else if(ele.startsWith("Change")){
                String[] split = ele.split(" ");
                map.put(split[1], split[2]);
            }
        }


        List<String> answerList = new ArrayList<>();
        for(String ele : record){
            if(ele.startsWith("Enter")){
                String[] split = ele.split(" ");
                answerList.add(map.get(split[1]) + "님이 들어왔습니다.");
            } else if(ele.startsWith("Leave")){
                String[] split = ele.split(" ");
                answerList.add(map.get(split[1]) + "님이 나갔습니다.");
            }
        }

        return answerList.stream().toArray(String[]::new);
    }

}
