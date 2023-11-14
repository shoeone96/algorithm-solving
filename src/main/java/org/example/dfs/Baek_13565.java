package org.example.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_13565 {
    static int M, N;
    static int [][] graph;
    static String answer = "NO";
    static int [] intX = {-1, 0, 1, 0};
    static int [] intY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        input();
        for(int i = 1; i <=N; i++){
            if(graph[1][i] == 1){
                solution(1, i);
            }
            if(answer.equals("YES")) break;
        }
        System.out.println(answer);
    }

    private static void solution(int positionY, int positionX) {
        graph[positionY][positionX] = 0;
        if (positionY == M){
            answer = "YES";
            return;
        }
        for(int i = 0; i < 4; i++){
            int newX = intX[i] + positionX;
            int newY = intY[i] + positionY;
            if (graph[newY][newX] == 1){
                solution(newY, newX);
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        graph = new int[M + 2][N + 2];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(bf.readLine());
            String line = st.nextToken();
            for (int j = 1; j <= N; j++) {
                if(line.charAt(j-1) == '0'){
                    graph[i][j] = 1;
                } else graph [i][j] = 0;
            }
        }
    }
}
