package org.example.brute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_15652 {

    static int M, N;
    static StringBuilder answer = new StringBuilder();
    static int[] arr;

    public static void main(String[] args) throws IOException {
        input();
        prod(1);
        System.out.println(answer);
    }

    private static void prod(int index) {
        if (index == M + 1){
            for(int i = 1; i < arr.length; i++){
                answer.append(arr[i]).append(" ");
            }
            answer.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++){
            if(i >= arr[index - 1]){
                arr[index] = i;
                prod(index + 1);
                arr[index] = 0;
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M + 1];
    }

}
