package org.example.brute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_15651 {

    static int N;
    static int M;
    static int[] arr;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        prod(1);

        System.out.println(answer);
    }

    public static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M + 1];
    }

    public static void prod(int size) {
        if (size == M + 1) {
            for (int i = 1; i <= M; i++) {
                answer.append(arr[i])
                    .append(" ");
            }
            answer.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            arr[size] = i;
            prod(size + 1);
        }

    }

}
