package org.example.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_11652 {

    static int N;
    static long[] arr;
    static int answerCount;
    static long answer;

    public static void main(String[] args) throws IOException {
        input();
        prod();
    }

    private static void prod() {
        long beforeNum = arr[0];
        answer = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == beforeNum) {
                count++;
            } else {
                if (count > answerCount) {
                    answerCount = count;
                    answer = beforeNum;
                }
                count = 1;
            }
            beforeNum = arr[i];
        }

        if(count > answerCount){
            answerCount = count;
            answer = beforeNum;
        }

        System.out.println(answer);
    }

    private static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new long[N];
        answerCount = 1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);
    }

}
