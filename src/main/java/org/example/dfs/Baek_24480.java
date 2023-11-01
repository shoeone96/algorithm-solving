package org.example.dfs;

import java.util.*;
import java.io.*;

public class Baek_24480 {
    static List<Integer> [] graph;
    static boolean [] visited;
    static int N, M, R;
    static int [] orders;
    static int order = 1;

    public static void main(String[] args) throws IOException{
        input();
        solution(R);
        for(int i = 1; i < orders.length; i++){
            System.out.println(orders[i]);
        }
    }

    private static void solution(int index) {
        visited[index] = true;
        orders[index] = order++;

        for(int i = 0; i < graph[index].size(); i++){
            if(!visited[graph[index].get(i)])
                solution(graph[index].get(i));
        }
    }

    private static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for(int i = 0;  i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        visited = new boolean[N + 1];
        orders = new int[N+1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);

        }

        for(List<Integer> node : graph){
            Collections.sort(node, Comparator.reverseOrder());
        }
    }
}
