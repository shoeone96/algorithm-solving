package org.example.dikstra;

import java.io.*;
import java.util.*;

public class Baek_1916 {

    static int N;
    static int M;
    static List<Edge>[] edges;
    static int start;
    static int destination;
    static int[] distances;
    static class Edge {
        int end;
        int price;
        public Edge(int end, int price) {
            this.end = end;
            this.price = price;
        }

    }
    static class Info{
        int end;
        int distance;
        public Info(int end, int distance){
            this.end = end;
            this.distance = distance;
        }

    }


    public static void main(String[] args) throws IOException {
        input();
        dijkstra(start);
        System.out.println(distances[destination]);
    }

    private static void dijkstra(int start) {
        for(int i = 1; i <= N; i++){
            distances[i] = Integer.MAX_VALUE;
        }
        distances[start] = 0;
        PriorityQueue<Info> infos = new PriorityQueue<>(Comparator.comparing(info -> info.distance));
        infos.add(new Info(start, 0));

        while(!infos.isEmpty()){
            Info info = infos.poll();
            if(info.distance != distances[info.end]) continue;

            for(Edge edge : edges[info.end]){
                if (distances[info.end] + edge.price >= distances[edge.end]) continue;
                distances[edge.end] = info.distance + edge.price;
                infos.add(new Info(edge.end, distances[edge.end]));
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());
        distances = new int[N + 1];
        edges = new ArrayList[N + 1];
        for(int i = 1; i <=N; i++){
            edges[i] = new ArrayList<>();
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            edges[from].add(new Edge(to, price));
        }
        st = new StringTokenizer(bf.readLine());
        start = Integer.parseInt(st.nextToken());
        destination = Integer.parseInt(st.nextToken());
    }

}
