package org.example.stackQueue;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean [] visited = new boolean[rooms.size()];

        queue.add(0);
        visited[0] = true;

        while(!queue.isEmpty()){
            Integer poll = queue.poll();
            for(int ele : rooms.get(poll)){
                if(!visited[ele]){
                    queue.add(ele);
                    visited[ele] = true;
                }
            }
        }
        boolean answer = true;
        for(boolean visit : visited){
            if(!visit){
                answer = false;
            }
        }
        return answer;
    }
}
