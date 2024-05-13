package org.example.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_11659 {

    public static void main(String[] args) throws IOException{
        int N, M;
        int[] sum;

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sum = new int[N + 1];

        st = new StringTokenizer(bf.readLine());
        for(int i = 1; i <= N; i++){
            sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
        }
       StringBuilder answer = new StringBuilder();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            answer.append(sum[end] - sum[start-1]).append("\n");
        }
        System.out.println(answer);
    }

}
