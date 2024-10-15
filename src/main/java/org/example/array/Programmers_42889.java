package org.example.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Programmers_42889 {

    public static void main(String[] args) {
        Programmers_42889 sol = new Programmers_42889();
        sol.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
    }

    public int[] solution(int N, int[] stages) {
        int[] challengeStage = new int[N + 2];
        for (int i = 0; i < stages.length; i++) {
            challengeStage[stages[i]]++;
        }

        Map<Integer, Double> failRate = new HashMap<>();
        double total = stages.length;

        for (int i = 1; i <= N; i++) {
            if (challengeStage[i] == 0) {
                failRate.put(i, 0.);
                continue;
            }

            failRate.put(i, challengeStage[i] / total);
            total -= challengeStage[i];

        }
        return failRate.entrySet()
            .stream()
            .sorted((a, b) -> Double.compare(b.getValue(), a.getValue()))
            .mapToInt(Map.Entry::getKey)
            .toArray();
    }

}
