package org.example.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1012 {
    static boolean[][] graph;
    static int T, M, N, K;
    static int answer = 0;
    static int arrY[] = {-1, 1, 0, 0};
    static int arrX[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        T = Integer.parseInt(st.nextToken());
        while (T-- > 0) {
            input(bf, st);
            solution();
            System.out.println(answer);
            answer = 0;
        }
    }

    private static void solution() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (graph[i][j]) {
                    answer++;
                    graph[i][j] = false;
                    dfs(i, j);
                }
            }
        }
    }

    private static void dfs(int y, int x) {
        for (int i = 0; i < arrX.length; i++) {
            int moveY = y + arrX[i];
            int moveX = x + arrY[i];
            if (graph[moveY][moveX]) {
                graph[moveY][moveX] = false;
                dfs(moveY, moveX);
            }

        }
    }

    private static void input(BufferedReader bf, StringTokenizer st) throws IOException {
        st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new boolean[N + 2][M + 2];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[y + 1][x + 1] = true;
        }

    }
}
