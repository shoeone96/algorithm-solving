package org.example.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_2178 {

    static class RowCol{
        int row;
        int col;

        public RowCol(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    static int N, M;
    static int[][] graph;
    static boolean[][] isVisited;
    static int[][] move = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            char[] charArray = st.nextToken()
                .toCharArray();
            for (int j = 0; j < charArray.length; j++) {
                graph[i][j] = Character.getNumericValue(charArray[j]);
            }
        }

        bfs();
        System.out.println(graph[N-1][M-1]);
    }

    private static void bfs() {
        Queue<RowCol> queue = new ArrayDeque<>();
        queue.add(new RowCol(0,0));
        isVisited[0][0] = true;

        while(!queue.isEmpty()){
            RowCol poll = queue.poll();
            for(int i = 0; i < move.length; i++){
                int newRow = poll.row + move[i][0];
                int newCol = poll.col + move[i][1];
                if(isValidate(newRow, newCol)){
                    queue.add(new RowCol(newRow, newCol));
                    graph[newRow][newCol] = graph[poll.row][poll.col] + 1;
                    isVisited[newRow][newCol] = true;
                }
            }
        }
    }

    private static boolean isValidate(int row, int col){
        if(row < 0 || row >= N || col < 0 || col >= M){
            return false;
        }

        if(isVisited[row][col]){
            return false;
        }

        if(graph[row][col] == 0){
            return false;
        }

        return true;
    }


}
