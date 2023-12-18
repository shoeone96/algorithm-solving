package org.example.deque;

import java.io.*;
import java.util.*;

/**
 * 1~N번 풍선 존재
 * N 다음은 1, 1 이전은 N(원형 리스트의 느낌)
 * 터진 풍선의 오른쪽, 왼쪽을 그 숫자에 따라 이동
 * 터진 숫자는 없어져야 함
 * arrayDeque 에 담기
 * 그 인덱스를 정답에 담기
 *
 */
public class Baek_2346 {

    static int N;
    static Deque<int []> deque = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        input();
        sol();
        sb.append(deque.poll()[0]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++){
            int [] arr = {i + 1, Integer.parseInt(st.nextToken())};
            deque.add(arr);
        }
    }

    private static void sol() {
        while(deque.size() > 1){
            int [] arr = deque.pollFirst();
            sb.append(arr[0]).append(" ");
            int next = arr[1];
            if(next > 0){
                for(int i = 1; i < next; i++){
                    deque.offerLast(deque.pollFirst());
                }
            }
            if(next < 0){
                for(int i = next; i < 0; i++){
                    deque.offerFirst(deque.pollLast());
                }
            }
        }
    }
}
