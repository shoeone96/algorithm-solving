package org.example.twoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_1253 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int answer = 0;

        for (int i = 0; i < N; i++) {
            int target = arr[i];
            int left = 0;
            int right = N - 1;

            while (left < right) {
                if (left == i) {
                    left++;
                    continue;
                }
                if (right == i) {
                    right--;
                    continue;
                }

                if (arr[left] + arr[right] == target) {
                    answer++;
                    break;
                }

                if (arr[left] + arr[right] > target) {
                    right--;
                    continue;
                }

                left++;
            }
        }
        System.out.println(answer);
    }

}
