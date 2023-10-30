package org.example.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_11724 {
    public static int N, M;
    public static boolean[][] graph;
    public static boolean[] visit;
    public static int answer = 0;

    public static void main(String[] args) throws IOException{
        input();
        for(int i  = 1; i < visit.length; i++){
            if(visit[i])continue;
            solution(i);
            answer++;
        }
        System.out.println(answer);
    }

    private static void solution(int input) {
        visit[input] = true;
        for(int i = 1; i <= N; i++){
            if(graph[input][i] && !visit[i]){
                solution(i);
            }
        }
    }

    public static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new boolean[N + 1][N + 1];
        visit = new boolean[N + 1];
        int x, y;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(bf.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            graph[x][y] = true;
            graph[y][x] = true;
        }
    }
}
