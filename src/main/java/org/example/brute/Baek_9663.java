package org.example.brute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baek_9663 {

    static int N;
    static int answer;
    static boolean[] colVisited;
    static List<Integer> sumRowCol = new ArrayList<>();
    static List<Integer> minusRowCol = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        prod(0);
        System.out.println(answer);
    }

    public static void prod(int row) {
        if (row == N) {
            answer++;
            return;
        }

        for (int col = 0; col < N; col++) {
            if (!colVisited[col] && !sumRowCol.contains(row + col) && !minusRowCol.contains(row - col)) {
                colVisited[col] = true;
                sumRowCol.add(row + col);
                minusRowCol.add(row - col);

                prod(row + 1);

                colVisited[col] = false;
                sumRowCol.remove(Integer.valueOf(row + col));
                minusRowCol.remove(Integer.valueOf(row - col));
            }
        }
    }

    public static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        colVisited = new boolean[N];
        answer = 0;
    }

}
