package org.example.stackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_17298 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int standard = arr[i];
            int ngeIndex = i + 1;
            while (true) {
                if (ngeIndex == n) {
                    answer.append(-1).append(" ");
                    break;
                }
                if (arr[ngeIndex] > standard) {
                    answer.append(arr[ngeIndex]).append(" ");
                    break;
                }

                ngeIndex++;
            }
        }

        System.out.println(answer);
    }

}
