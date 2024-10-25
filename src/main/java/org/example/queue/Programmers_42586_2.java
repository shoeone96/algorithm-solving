package org.example.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Programmers_42586_2 {

    public static void main(String[] args) {
        Programmers_42586_2 solution = new Programmers_42586_2();
        int [] progresses = {95, 90, 99, 99, 80, 99};
        int [] speeds = {1, 1, 1, 1, 1, 1};
        int[] solution1 = solution.solution(progresses, speeds);
        System.out.println(Arrays.toString(solution1));
    }
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answerList = new ArrayList<>();
        Queue<Integer> wait = new ArrayDeque<>();

        for(int i = 0; i < progresses.length; i++){
            int x = (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) % speeds[i] > 0){
                x++;
            }
            wait.add(x);
        }

        while(!wait.isEmpty()){
            int size = 0;
            int start = wait.peek();
            while(!wait.isEmpty() && wait.peek() <= start){
                wait.poll();
                size++;
            }
            answerList.add(size);
        }

        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}
