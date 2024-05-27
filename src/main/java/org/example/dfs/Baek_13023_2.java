package org.example.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baek_13023_2 {

    static int N, M;
    static List<Integer>[] graph;
    static boolean[] isVisited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new List[N];
        isVisited = new boolean[N];
        answer = 0;

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
            isVisited[i] = true;
            dfs(i, 1);
            if (answer == 1) {
                break;
            }
            isVisited[i] = false;
        }
        System.out.println(answer);
    }

    private static void dfs(int person, int count) {
        if (count == 5) {
            answer = 1;
            return;
        }

        for (int i = 0; i < graph[person].size(); i++) {
            if(!isVisited[graph[person].get(i)]){
                isVisited[graph[person].get(i)] = true;
                dfs(graph[person].get(i), count + 1);
                isVisited[graph[person].get(i)] = false;
            }
        }
    }

}
