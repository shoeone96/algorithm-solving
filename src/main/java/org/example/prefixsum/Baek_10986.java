package org.example.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_10986 {

    static int N, M;
    static int answer;
    static int [] visited;
    static int [] arr;
    static int [] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        visited = new int[2];
        answer = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        sum = new int[N + 1];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i + 1] = sum[i] + arr[i];
        }
        prod(0);

        System.out.println(answer);
    }


    static void prod(int count){
        if(count == 2){
            int part = sum[visited[1]] - sum[visited[0]];
            if(part ==0){
                return;
            }
            if(part % M == 0){
                answer++;
            }
            return;
        }
        for(int i = 0; i <= N; i++){
            if(count == 0 || visited[count-1] < i){
                visited[count] = i;
                prod(count + 1);
                visited[count] = 0;
            }
        }
    }

}
