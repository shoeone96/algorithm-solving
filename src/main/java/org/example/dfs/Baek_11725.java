package org.example.dfs;

import java.util.*;
import java.io.*;

public class Baek_11725 {

    public static int R;
    public static List<Integer>[] graph;
    public static boolean[] visited;
    public static int [] answer;
    public static int before = -1;

    public static void main(String[] args) throws IOException {
        input();
        solution(1, before);
        for(int i = 2; i < answer.length; i++){
            System.out.println(answer[i]);
        }
    }

    private static void solution(int input, int before) {
        visited[input] = true;
        answer[input] = before;

        for(int i = 0; i< graph[input].size(); i++){
            if(!visited[graph[input].get(i)]){
                solution(graph[input].get(i), input);
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        R = Integer.parseInt(st.nextToken());

        visited = new boolean[R + 1];
        answer = new int[R + 2];
        graph = new List[R + 2];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < R - 1; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }
    }
}
