package org.example.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1012_2 {

    static int T, M, N, K;
    static int answer;
    static boolean[][] arr;
    static int[][] locationCheck = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            input(bf);
            for (int j = 0; j < arr.length; j++) {
                for (int k = 0; k < arr[0].length; k++) {
                    if (arr[j][k]) {
                        prod(j, k);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }

    private static void prod(int row, int col) {
        arr[row][col] = false;
        for (int i = 0; i < 4; i++) {
            if (isValidate(row, col, i) && arr[row + locationCheck[i][0]][col + locationCheck[i][1]]) {
                prod(row + locationCheck[i][0], col + locationCheck[i][1]);
            }
        }
    }

    private static boolean isValidate(int row, int col, int i) {
        if (row + locationCheck[i][0] < 0 || row + locationCheck[i][0] >= arr.length) {
            return false;
        }

        if (col + locationCheck[i][1] < 0 || col + locationCheck[i][1] >= arr[0].length) {
            return false;
        }
        return true;
    }

    private static void input(BufferedReader bf) throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        answer = 0;

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new boolean[N][M];
        int X;
        int Y;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(bf.readLine());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            arr[Y][X] = true;
        }
    }

}
