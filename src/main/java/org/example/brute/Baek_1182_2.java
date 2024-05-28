package org.example.brute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1182_2 {

    static int N, S;
    static int[] arr;
    static int answer;

    public static void main(String[] args) throws IOException {
        input();
        prod(0, 0);
        if(S == 0){
            answer--;
        }
        System.out.println(answer);
    }

    private static void prod(int index, int sum) {
        if (index == N) {
            if (sum == S) {
                answer++;
            }
        } else {
            prod(index + 1, sum);
            prod(index + 1, sum + arr[index]);
        }
    }

    private static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        answer = 0;
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

}
