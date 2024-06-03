package org.example.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baek_2667 {

    static int N;
    static boolean[][] graph;
    static List<Integer> answer;
    static int count;
    static int[][] move = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        graph = new boolean[N][N];
        answer = new ArrayList<>();
        count = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            char[] charArray = st.nextToken().toCharArray();
            for (int j = 0; j < N; j++) {
                graph[i][j] = charArray[j] == '1';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j]) {
                    count = 0;
                    dfs(i, j);
                    answer.add(count);
                }
            }
        }

        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append("\n");
        for(int i = 0; i < answer.size(); i++){
            sb.append(answer.get(i)).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int row, int col) {
        count++;
        graph[row][col] = false;

        for (int i = 0; i < move.length; i++) {
            int newRow = row + move[i][0];
            int newCol = col + move[i][1];
            if (isValidate(newRow, newCol) && graph[newRow][newCol]) {
                dfs(newRow, newCol);
            }
        }
    }

    private static boolean isValidate(int newRow, int newCol) {
        return !(newRow < 0 || newRow >= N || newCol < 0 || newCol >= N);
    }

}
