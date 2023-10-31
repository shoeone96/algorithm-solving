package org.example.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baek_24479 {

    public static int order = 1;
    public static int N, M, start;
    public static ArrayList<Integer>[] graph;
    public static boolean[] visited;
    public static int[] orders;

    public static void main(String[] args) throws IOException {
        input();
        solution(start);
        for (int i = 1; i < orders.length; i++) {
            System.out.println(orders[i]);
        }
    }

    private static void solution(int start) {
        visited[start] = true;
        orders[start] = order++;

        for (int i = 0; i < graph[start].size(); i++) {
            if (!visited[graph[start].get(i)]) {
                solution(graph[start].get(i));
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        visited = new boolean[N + 1];
        orders = new int[N + 1];

        int x, y;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }
        for (ArrayList<Integer> connect : graph){
            Collections.sort(connect);
        }
    }
}
