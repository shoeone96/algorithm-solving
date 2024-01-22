package org.example.dfs;

import java.util.*;
import java.io.*;

public class Baek_14502 {

    static int row;
    static int column;
    static int[][] map, tempMap;
    static int[][] move = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    static int result = 0;


    public static void main(String[] args) throws IOException {
        input();
        backtraking(0);
        System.out.println(result);
    }

    private static void backtraking(int count) {
        if (count == 3) {
            bfs();
            result = Math.max(result, checkingValue());
            return;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    backtraking(count + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static int checkingValue() {
        int checkedValue = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (tempMap[i][j] == 0){
                    checkedValue++;
                }
            }
        }
        return checkedValue;
    }

    private static void bfs() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                tempMap[i][j] = map[i][j];
            }
        }
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (map[i][j] == 2) {
                    queue.add(new int[] {i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int row = poll[0];
            int column = poll[1];
            for (int i = 0; i < 4; i++) {
                int newRow = row + move[i][0];
                int newColumn = column + move[i][1];
                if (validate(newRow, newColumn) && tempMap[newRow][newColumn] == 0) {
                    tempMap[newRow][newColumn] = 2;
                    queue.add(new int[] {newRow, newColumn});
                }
            }
        }
    }

    private static boolean validate(int newRow, int newColumn) {
        return newRow >= 0 && newRow < row && newColumn >= 0 && newColumn < column;
    }

    public static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        row = Integer.parseInt(st.nextToken());
        column = Integer.parseInt(st.nextToken());
        map = new int[row][column];
        tempMap = new int[row][column];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < column; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

}
