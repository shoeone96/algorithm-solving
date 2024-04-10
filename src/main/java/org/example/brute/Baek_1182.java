package org.example.brute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1182 {

    static int N, S;
    static int[] arr;
    static int answer;

    public static void main(String[] args) throws IOException {
        input();
        prod(1, 0);
        if(S == 0){
            answer--;
        }
        System.out.println(answer);
    }

    private static void prod(int ele, int sum) {
        if (ele == N + 1) {
            if(sum == S){
                answer++;
            }
            return;
        }
        prod(ele + 1, sum + arr[ele]);
        prod(ele + 1, sum);
    }

    private static void input() throws IOException {
        answer = 0;

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];

        st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

}
