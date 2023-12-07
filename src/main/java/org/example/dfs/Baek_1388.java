package org.example.dfs;

import java.io.*;
import java.util.*;


public class Baek_1388 {

    static int column;
    static int row;
    static int count = 0;
    static boolean[][] wood;
    static boolean[][] visited;
    static int[][] checkRow = {{-1, 0}, {1, 0}};
    static int[][] checkColumn = {{0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    private static void pro() {
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                if (!visited[i][j]) {
                    count++;
                    dfs(i, j);
                }
            }
        }
        System.out.println(count);
    }

    private static void dfs(int column, int row) {
        visited[column][row] = true;
        for (int i = 0; i < 2; i++) {
            int newColumn;
            int newRow;
            if (wood[column][row]) {
                newColumn = column + checkRow[i][1];
                newRow = row + checkRow[i][0];
            } else {
                newColumn = column + checkColumn[i][1];
                newRow = row + checkColumn[i][0];
            }
            if (!checkBoundary(newColumn, newRow)) {
                continue;
            }
            if ((wood[column][row] == wood[newColumn][newRow]) && !visited[newColumn][newRow]) {
                dfs(newColumn, newRow);
            }

        }
    }

    private static boolean checkBoundary(int newColumn, int newRow) {
        if (newColumn < 0 || newColumn >= column) {
            return false;
        }
        if (newRow < 0 || newRow >= row) {
            return false;
        }
        return true;
    }

    private static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        column = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());

        wood = new boolean[column][row];
        visited = new boolean[column][row];

        for (int i = 0; i < column; i++) {
            st = new StringTokenizer(bf.readLine());
            String line = st.nextToken();
            char[] part = line.toCharArray();
            for (int j = 0; j < row; j++) {
                if (part[j] == '-') {
                    wood[i][j] = true;
                }
            }
        }
    }
}
