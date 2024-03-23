package org.example.brute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_15649 {

    static int N, M;
    static int[] arr;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        prod(1);
        System.out.println(sb);
    }

    private static void prod(int index) {
        if (index == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(arr[i])
                    .append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visit[i]) {
                arr[index] = i;
                visit[i] = true;
                prod(index + 1);
                visit[i] = false;
            }
        }
    }
    private static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M + 1];
        visit = new boolean[N + 1];
    }

}
