package org.example.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_10986 {

    static int N, M;
    static long[] sum;
    static long[] left;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long answer = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sum = new long[N + 1];
        left = new long[M];

        st = new StringTokenizer(bf.readLine());
        for (int i = 1; i < N + 1; i++) {
            sum[i] = (sum[i - 1] + Integer.parseInt(st.nextToken())) % M;
            if (sum[i] == 0) {
                answer++;
            }
            left[(int) sum[i]]++;
        }

        for (int i = 0; i < M; i++) {
            if (left[i] > 1) {
                answer += (left[i] * (left[i] - 1) / 2);
            }
        }

        System.out.println(answer);
    }


}
