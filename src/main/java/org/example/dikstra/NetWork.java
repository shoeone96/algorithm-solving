package org.example.dikstra;

import java.util.*;

class Network {
    static class Edge{
        int to;
        int weight;
        public Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }

    static class Info{
        int to;
        int distance;
        public Info(int to, int distance){
            this.to = to;
            this.distance = distance;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<Edge> [] edges = new ArrayList [n+1];
        int[] distance = new int[n + 1];
        for(int i = 1; i <= n; i++){
            distance[i] = Integer.MAX_VALUE;
        }
        for(int i = 1; i <=n; i++){
            edges[i] = new ArrayList<>();
        }
        for(int i = 0; i < times.length; i++){
            int from = times[i][0];
            int to = times[i][1];
            int weight = times[i][2];
            edges[from].add(new Edge(to, weight));
        }
        PriorityQueue<Info> infos = new PriorityQueue<>(Comparator.comparing(info -> info.distance));
        infos.add(new Info(k, 0));
        distance[k] = 0;
        while(!infos.isEmpty()){
            Info info = infos.poll();
            if(info.distance != distance[info.to]) continue;

            for(Edge e : edges[info.to]){
                if(distance[info.to] + e.weight >= distance[e.to]) continue;
                distance[e.to] = distance[e.to] + e.weight;
            }
        }
        int answer = 0;
        for(int i = 1; i <=n; i++){
            if(distance[i] == Integer.MAX_VALUE) return -1;
            if(answer < distance[i]) answer = distance[i];
        }
        return answer;

    }
}
