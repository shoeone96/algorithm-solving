package org.example.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Programmers_42584 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for(int i = 1; i < prices.length; i++){
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                int pop = stack.pop();
                answer[pop] = i - pop;
            }

            stack.push(i);
        }

        while(!stack.isEmpty()){
            int pop = stack.pop();
            answer[pop] = prices.length -1 -pop;
        }

        return answer;
    }
}
