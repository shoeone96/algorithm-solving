package org.example.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek_1167 {

    static class Edge {

        int nextV;
        int dis;

        public Edge(int nextV, int dis) {
            this.nextV = nextV;
            this.dis = dis;
        }

    }

    static int N;
    static int answer;
    static boolean[] isVisited;
    static int[] distance;
    static ArrayList<Edge>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        isVisited = new boolean[N + 1];
        distance = new int[N + 1];
        answer = 0;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());
            int vIndex = Integer.parseInt(st.nextToken());
            graph[vIndex] = new ArrayList<>();
            while (true) {
                int nextV = Integer.parseInt(st.nextToken());
                if (nextV == -1) {
                    break;
                } else {
                    int dis = Integer.parseInt(st.nextToken());
                    graph[vIndex].add(new Edge(nextV, dis));
                }
            }
        }
        isVisited[1] = true;
        dfs(1, 0);

        int targetIndex = 1;
        for (int i = 1; i <= N; i++) {
            if (distance[i] > distance[targetIndex]) {
                targetIndex = i;
            }
        }
        isVisited = new boolean[N + 1];
        isVisited[targetIndex] = true;
        distance = new int[N + 1];
        dfs(targetIndex, 0);

        for(int i = 1; i < distance.length; i++){
            if(distance[i] > answer){
                answer = distance[i];
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int vIndex, int totalDistance) {
        for (int i = 0; i < graph[vIndex].size(); i++) {
            Edge nextEdge = graph[vIndex].get(i);
            if (!isVisited[nextEdge.nextV]) {
                isVisited[nextEdge.nextV] = true;
                distance[nextEdge.nextV] = totalDistance + nextEdge.dis;
                dfs(nextEdge.nextV, distance[nextEdge.nextV]);
            }
        }
    }

}
