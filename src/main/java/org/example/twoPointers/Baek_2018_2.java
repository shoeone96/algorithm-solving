package org.example.twoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2018_2 {

    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        answer = 0;
        prod(N);
        System.out.println(answer);
    }

    private static void prod(int N) {
        int left = 0;
        int right = 0;
        int sum = 0;
        while (left <= N && right <= N) {
            if(right == N && sum < N){
                break;
            }
            if(sum > N){
                sum -= left++;
                continue;
            }
            if(sum == N) {
                answer++;
            }
            right++;
            sum+= right;
        }
    }

}
