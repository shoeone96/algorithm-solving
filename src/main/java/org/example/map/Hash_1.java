package org.example.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Hash_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        String result = st.nextToken();
        Map<Character, Integer> votes = new HashMap<>();
        for(Character vote : result.toCharArray()){
            if(votes.containsKey(vote)){
                votes.put(vote, votes.get(vote) + 1);
                continue;
            }
            votes.put(vote, 1);
        }
        char answer = result.charAt(0);
        int answerCount = votes.get(answer);
        for(char key: votes.keySet()){
            if(votes.get(key) > answerCount){
                answer = key;
                answerCount = votes.get(key);
            }
        }
        System.out.println(answer);
    }

}
