package org.example.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programmers_42840 {

    static int[] one = {1, 2, 3, 4, 5};
    static int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
    static int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public static void main(String[] args) {
        Programmers_42840 programmers42840 = new Programmers_42840();
        int[] solution = programmers42840.solution(new int[]{1,3,2,4,2});
        System.out.println(Arrays.toString(solution));
    }

    public int[] solution(int[] answers) {
        int[] count = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if (one[i % one.length] == answers[i]) {
                count[0]++;
            }

            if (two[i % two.length] == answers[i]) {
                count[1]++;
            }

            if (three[i % three.length] == answers[i]) {
                count[2]++;
            }
        }
        List<Integer> answer = new ArrayList<>();
        int maxValue = -1;

        for (int i = 0; i < count.length; i++) {
            if (count[i] > maxValue) {
                maxValue = count[i];
            }
        }
        for(int i = 0; i < count.length; i++){
            if(count[i] == maxValue){
                answer.add(i + 1);
            }
        }

        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }

}
