package org.example.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_1015 {

    static int N;
    static int [] A;
    static int [] B;

    public static void main(String[] args) throws IOException{
        input();
        prod();
    }

    private static void prod() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(A[i] == B[j]){
                    B[j] = -1;
                    sb.append(j).append(" ");
                    break;
                }
            }
        }
        System.out.println(sb);
    }

    private static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        A = new int [N];
        B = new int [N];
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = A[i];
        }
        Arrays.sort(B);
    }
}
