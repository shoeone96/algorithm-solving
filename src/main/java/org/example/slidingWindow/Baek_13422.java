package org.example.slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_13422 {

    static int N, M, K, T;
    static int[] houses;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            input(bf, st);
            if (M == N) {
                long sum = 0;
                for (int j = 0; j < houses.length; j++) {
                    sum += houses[j];
                }
                if (sum < K) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else {
                long sum = 0;
                int answer = 0;
                for (int j = 0; j < N; j++) {
                    if (j == 0) {
                        for (int k = 0; k < M; k++) {
                            sum += houses[k];
                        }
                        if (sum < K) {
                            answer++;
                        }
                    }
                    if (j >= 1) {
                        sum -= houses[j - 1];
                        sum += houses[(j + M - 1) % N];
                        if (sum < K) {
                            answer++;
                        }
                    }
                }
                System.out.println(answer);
            }
        }
    }

    private static void input(BufferedReader bf, StringTokenizer st) throws IOException {
        st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        houses = new int[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(st.nextToken());
        }
    }

}
