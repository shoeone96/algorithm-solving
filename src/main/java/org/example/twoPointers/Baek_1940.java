package org.example.twoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_1940 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int right = 1;
        int left = 0;
        int answer = 0;

        while (right < N && left < N - 1) {
            if (arr[left] + arr[right] < M) {
                if (right < N - 1) {
                    right++;
                    continue;
                }
                if (right == N - 1) {
                    left++;
                    right = left + 1;
                    continue;
                }
            }

            if (arr[left] + arr[right] == M) {
                answer++;
            }

            left++;
            right = left + 1;
        }

        System.out.println(answer);
    }

}
