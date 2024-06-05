package org.example.binarySearch;

import static java.util.Arrays.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_1920 {

    static int N, M;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        int [] A = new int[N];
        st = new StringTokenizer(bf.readLine());
        for(int i = 0 ; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int [] arr = new int[M];
        for(int i = 0; i < M; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        for (int j : arr) {
            if (binarySearch(A, j) < 0) {
                answer.append(0).append("\n");
            } else {
                answer.append(1).append("\n");
            }
        }

        System.out.println(answer);
    }
}
