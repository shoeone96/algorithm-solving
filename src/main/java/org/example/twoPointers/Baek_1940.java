package org.example.twoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_1940 {


    public static void solution(int n, int m, int[] arr) {
        int lt = 0;
        int rt = n-1;
        int answer = 0;
        while(lt < rt){
            if(arr[lt] + arr[rt] ==  m){
                answer++;
                lt ++;
                rt --;
            }else if(arr[lt] + arr[rt] < m){
                lt++;
            }else {
                rt--;
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        solution(N, M, arr);

    }
}
