package org.example.dfs;

import java.util.*;
import java.io.*;

public class Baek_1260 {

    static List<Integer>[] graph;
    static boolean[] visited;
    static int N, M, V;
    static StringBuilder answer = new StringBuilder();
    static boolean [] bfsDone;
    static int order = 1;
    static Queue<Integer> bfsQueue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        input();
        dfs(V);
        print();
        reset();
        bfs(V);
        print();
    }

    private static void print() {
        System.out.println(answer.toString().trim());
    }

    private static void reset() {
        answer = new StringBuilder();
        visited = new boolean[N + 1];
        order = 1;
    }

    private static void bfs(int input) {
        bfsQueue.add(input);
        visited[input] = true;
        answer.append(input).append(" ");
        while(!bfsQueue.isEmpty()){
            int content = bfsQueue.poll();
            for(int i : graph[content]){
                if (!visited[i]){
                    bfsQueue.add(i);
                    visited[i] = true;
                    answer.append(i).append(" ");
                }
            }
        }
    }

    private static void dfs(int input) {
        visited[input] = true;
        answer.append(input).append(" ");

        for (int i = 0; i < graph[input].size(); i++) {
            if (!visited[graph[input].get(i)])
                dfs(graph[input].get(i));
        }
    }

    private static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        visited = new boolean[N + 1];
        bfsDone = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        for (List<Integer> connect : graph) {
            Collections.sort(connect);
        }
    }


}
