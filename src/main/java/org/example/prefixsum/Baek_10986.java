package org.example.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_10986 {

    static int N, M;
<<<<<<< HEAD
    static int answer;
<<<<<<< HEAD
    static int [] visited;
    static int [] arr;
    static int [] sum;
=======
    static long[] sum;
    static int[] left;
>>>>>>> cafbc2e (PREFIX SUM: 백준 10986 수정 완료)
=======
    static long[] sum;
    static long[] left;
>>>>>>> d1bc63a (PREFIX SUM: 백준 10986 수정 완료)

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
<<<<<<< HEAD
<<<<<<< HEAD
        visited = new int[2];
=======
>>>>>>> cafbc2e (PREFIX SUM: 백준 10986 수정 완료)
        answer = 0;
=======
        long answer = 0;
>>>>>>> d1bc63a (PREFIX SUM: 백준 10986 수정 완료)
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

<<<<<<< HEAD
        arr = new int[N];
        sum = new int[N + 1];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i + 1] = sum[i] + arr[i];
        }
        prod(0);
=======
        sum = new long[N + 1];
        left = new long[M];

        st = new StringTokenizer(bf.readLine());
        for (int i = 1; i < N + 1; i++) {
            sum[i] = (sum[i - 1] + Integer.parseInt(st.nextToken())) % M;
            if (sum[i] == 0) {
                answer++;
            }
            left[(int) sum[i]]++;
        }

        for (int i = 0; i < M; i++) {
            if (left[i] > 1) {
                answer += (left[i] * (left[i] - 1) / 2);
            }
        }
>>>>>>> cafbc2e (PREFIX SUM: 백준 10986 수정 완료)

        System.out.println(answer);
    }


<<<<<<< HEAD
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

=======
>>>>>>> cafbc2e (PREFIX SUM: 백준 10986 수정 완료)
}
