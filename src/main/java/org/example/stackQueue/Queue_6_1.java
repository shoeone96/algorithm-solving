package org.example.stackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Queue_6_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new ArrayDeque<>();

        for(int i = 1; i <=N; i++){
            queue.offer(i);
        }

        int count = 0;
        while (true){
            Integer poll = queue.poll();
            count++;
            if(count != K){
                queue.offer(poll);
            }
            if(count == K){
                count = 0;
            }
            if(queue.size() == 1){
                break;
            }
        }

        System.out.println(queue.poll());
    }

}
