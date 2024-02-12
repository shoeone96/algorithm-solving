package org.example.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Leet_406 {

    public int[][] reconstructQueue(int[][] people) {
        Queue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]
        );

        for(int [] person : people){
            pq.add(person);
        }

        List<int[]> result = new ArrayList<>();

        while(!pq.isEmpty()){
            int [] person = pq.poll();
            result.add(person[1], person);
        }

        return result.toArray(new int[people.length][2]);
    }

}
