package org.example.queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Programmers_159994 {

    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Deque<String> queue1 = new ArrayDeque<>(Arrays.asList(cards1));
        Deque<String> queue2 = new ArrayDeque<>(Arrays.asList(cards2));
        Deque<String> goalQueue = new ArrayDeque<>(Arrays.asList(goal));

        while(!goalQueue.isEmpty()){
            String poll = goalQueue.poll();
            if(!queue1.isEmpty() && queue1.peek().equals(poll)){
                queue1.poll();
            } else if(!queue2.isEmpty() && queue2.peek().equals(poll)){
                queue2.poll();
            } else{
                return "No";
            }
        }

        return "Yes";
    }

}
