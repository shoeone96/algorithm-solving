package org.example.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_11724_2 {

    static int N, M;
    static int answer;
    static boolean [] visited;
    static boolean [][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        answer = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new boolean[N+1][N+1];
        visited = new boolean[N+1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            graph[row][col] = true;
            graph[col][row] = true;
        }

        for(int i = 1; i <= N; i++) {
            if(!visited[i]){
                dfs(i);
                answer++;
            }
        }

        System.out.println(answer);
    }

    static void dfs(int index){
        visited[index] = true;
        for(int i = 1; i <= N; i++){
            if(graph[index][i] && !visited[i]){
                dfs(i);
            }
        }
    }

}
