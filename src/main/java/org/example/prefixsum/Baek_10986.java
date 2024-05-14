package org.example.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_10986 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int answer = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] arr = new int[N];

        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i <N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++){
            int pointer = i;
            int sum = 0;
            while(pointer < N){
                sum += arr[pointer];
                if(sum % M == 0){
                    answer++;
                }
                pointer++;
            }
        }

        System.out.println(answer);
    }

}
