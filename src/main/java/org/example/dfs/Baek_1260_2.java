package org.example.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_1260_2 {

    static int N, M, V;
    static List<Integer>[] graph;
    static boolean[] isVisited;
    static StringBuilder answer;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        answer = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new List[N + 1];
        isVisited = new boolean[N + 1];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 0; i < graph.length; i++) {
            Collections.sort(graph[i]);
        }

        dfs(V);
        answer.append("\n");
        isVisited = new boolean[N + 1];
        bfs(V);
        System.out.println(answer);
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(v);
        isVisited[v] = true;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            answer.append(current).append(" ");
            for (int next : graph[current]) {
                if (!isVisited[next]) {
                    queue.add(next);
                    isVisited[next] = true;
                }
            }
        }
    }

    private static void dfs(int v) {
        isVisited[v] = true;
        answer.append(v)
            .append(" ");
        for (int i = 0; i < graph[v].size(); i++) {
            if (!isVisited[graph[v].get(i)]) {
                dfs(graph[v].get(i));
            }
        }
    }

}
