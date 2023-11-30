package org.example.dfs;

import java.util.*;
import java.io.*;

public class Baek_4963 {

    static int w;
    static int h;
    static boolean[][] land;
    static int[][] move = new int[][]{{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    static int answer = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        while (true) {
            input(bf, st);
            if (w == 0 && h ==0) break;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (land[i][j]) {
                        dfs(i, j);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
            answer = 0;
            st = new StringTokenizer(bf.readLine());
        }
    }

    private static void input(BufferedReader bf, StringTokenizer st) throws IOException {
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        land = new boolean[h][w];

        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < w; j++) {
                String ele = st.nextToken();
                land[i][j] = (ele.equals("0")) ? false : true;
            }
        }
    }

    private static void dfs(int y, int x) {
        land[y][x] = false;
        for (int i = 0; i < move.length; i++) {
            if (x + move[i][0] < 0 ||
                y + move[i][1] < 0 ||
                x + move[i][0] > land[0].length -1 ||
                y + move[i][1] > land.length - 1) continue;
            int newX = x + move[i][0];
            int newY = y + move[i][1];
            if (land[newY][newX]) {
                dfs(newY, newX);
            }
        }
    }


}
