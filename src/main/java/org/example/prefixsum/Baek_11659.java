package org.example.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_11659 {

    static int N, M;
    static int[] arr;
    static int[] sum;

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        sum = new int[N + 1];

        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(i == 0){
                sum[i] = arr[i];
                continue;
            }
            sum[i] = sum[i-1] + arr[i];
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if(start == 1){
                System.out.println(sum[end-1]);
                continue;
            }
            System.out.println(sum[end-1] - sum[start-2]);
        }
    }

}
