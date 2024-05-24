package org.example.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek_13023 {

    static int N, M;
    static ArrayList<Integer>[] graph;
    static boolean[] isVisited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = 0;

        graph = new ArrayList[N];
        isVisited = new boolean[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            isVisited[i] = true;
            dfs(0, i);
            if (answer == 1) {
                break;
            }
            isVisited[i] = false;
        }
        System.out.println(answer);
    }

    static void dfs(int count, int row) {
        if (count == 4) {
            answer = 1;
            return;
        }
        for (int j = 0; j < graph[row].size(); j++) {
            if (!isVisited[graph[row].get(j)]) {
                isVisited[graph[row].get(j)] = true;
                dfs(count + 1, graph[row].get(j));
                if (answer == 1) {
                    return;
                }
                isVisited[graph[row].get(j)] = false;
            }
        }
    }

}
