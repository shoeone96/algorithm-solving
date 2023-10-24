package org.example.dfs;

import java.io.*;
import java.util.StringTokenizer;

public class Baek_2606 {

    static boolean[][] graph;
    static boolean[] visited;
    static int answer;
    static int count;
    static int connect;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        count = Integer.parseInt(bf.readLine());
        connect = Integer.parseInt(bf.readLine());

        graph = new boolean[count + 1][count + 1];
        visited = new boolean[count + 1];

        for (int i = 0; i < connect; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = true;
            graph[y][x] = true;
        }

        dfs(1);
        System.out.println(answer - 1);
    }

    private static void dfs(int i) {
        visited[i] = true;
        answer++;

        for (int j = 1; j <= count; j++) {
            if (!visited[j] && graph[i][j]){
                dfs(j);
            }
        }
    }
}
