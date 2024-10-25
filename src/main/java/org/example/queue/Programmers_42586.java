package org.example.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Programmers_42586 {

    public static void main(String[] args) {
        Programmers_42586 solution = new Programmers_42586();
        int [] progresses = {95, 90, 99, 99, 80, 99};
        int [] speeds = {1, 1, 1, 1, 1, 1};
        int[] solution1 = solution.solution(progresses, speeds);
        System.out.println(Arrays.toString(solution1));
    }
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answerList = new ArrayList<>();
        Queue<Integer> wait = new ArrayDeque<>();
        for(int i = 0; i < progresses.length; i++){
            wait.add(progresses[i]);
        }
        int startIndex = 0;
        while(!wait.isEmpty()){
            for(int i = startIndex; i < speeds.length; i++){
                int progress = wait.poll() + speeds[i];
                wait.add(progress);
            }

            int size = 0;
            while(!wait.isEmpty() && wait.peek() >= 100){
                wait.poll();
                size++;
                startIndex++;
            }

            if(size > 0){
                answerList.add(size);
            }
        }

        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}
