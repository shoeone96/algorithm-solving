package org.example.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_2178 {

    static int N, M;
    static boolean [][] graph;
    static boolean [][] isVisited;
    static int answer;
    static int [][] move = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        answer = Integer.MAX_VALUE;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new boolean[N][M];
        isVisited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(bf.readLine());
            char[] charArray = st.nextToken().toCharArray();
            for(int j = 0; j < charArray.length; j++){
                if(charArray[j] == '1'){
                    graph[i][j] = true;
                } else {
                    graph[i][j] = false;
                }
            }
        }

        answer = bfs(0, 0);
        System.out.println(answer);
    }

    private static int bfs(int startRow, int startCol) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startRow, startCol});
        isVisited[startRow][startCol] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];

                if (row == N - 1 && col == M - 1) {
                    return count;
                }

                for (int[] moveDirection : move) {
                    int newRow = row + moveDirection[0];
                    int newCol = col + moveDirection[1];

                    if (isValidate(newRow, newCol) && !isVisited[newRow][newCol]) {
                        queue.add(new int[]{newRow, newCol});
                        isVisited[newRow][newCol] = true;
                    }
                }
            }
            count++;
        }
        return -1;
    }

    private static boolean isValidate(int newRow, int newCol) {
        if(newRow < 0 || newRow >= N || newCol < 0 || newCol >=M ){
            return false;
        }

        if(!graph[newRow][newCol]){
            return false;
        }

        return true;
    }

}
