package org.example.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Hash_3 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder answer = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Map<Integer, Integer> salesMap = new HashMap<>();
        for (int i = 0; i < K; i++) {
            salesMap.put(arr[i], salesMap.getOrDefault(arr[i], 0) + 1);
        }
        answer.append(salesMap.size()).append(" ");

        for (int i = 1; i <= N - K; i++) {
            Integer value = salesMap.get(arr[i - 1]);
            if (value == 1) {
                salesMap.remove(arr[i - 1]);
            } else {
                salesMap.put(arr[i - 1], salesMap.get(arr[i - 1]) - 1);
            }

            salesMap.put(arr[i + K -1], salesMap.getOrDefault(arr[i + K-1], 0) + 1);
            answer.append(salesMap.size()).append(" ");
        }

        System.out.println(answer.toString().trim());
    }

}
