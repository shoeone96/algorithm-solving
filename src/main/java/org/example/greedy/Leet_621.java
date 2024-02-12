package org.example.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Leet_621 {

    public int leastInterval(char[] tasks, int n) {

        // 작업이 얼마나 있는지 넣기
        Map<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        // 일이 큰 순서대로 오름차순 넣기
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.addAll(map.values());

        int cycles = 0;
        while (!pq.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            // 처음 데이터 + n개만큼 뽑아 사이클 돌기
            // 한 종류밖에 안남은 경우 하나만 넣는다.
            for (int i = 0; i < n + 1; i++) {
                if (!pq.isEmpty()) {
                    temp.add(pq.remove() - 1);
                }
            }

            // 사이클이 다 돈 이후에는 다시 pq에 남은 작업들을 넣기
            for (int freq : temp) {
                if (freq > 0) {
                    pq.add(freq);
                }
            }

            // 기본적으로 0~n 번 작업한 것을 반영
            // 한 종류만 남은 걸 넣고 아직 일이 남았을 때 1만큼 일하고 n만큼 일해 n+1 반영
            // 마지막 남은 일이 있을 때 한 종류 남으면 그것만 추가, 여러 종류 다 반영해서 끝나면 그 사이즈만큼 추가
            cycles += pq.isEmpty() ? temp.size() : n + 1;
        }

        return cycles;

    }

}
