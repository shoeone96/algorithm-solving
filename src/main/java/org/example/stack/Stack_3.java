package org.example.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Stack_3 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int answer = 0;
        int N = Integer.parseInt(st.nextToken());
        Deque<Integer>[] stackArr = new Deque[N + 1];

        for (int i = 1; i <= N; i++) {
            stackArr[i] = new ArrayDeque<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= N; j++) {
                int ele = Integer.parseInt(st.nextToken());
                if (ele != 0) {
                    stackArr[j].push(ele);
                }
            }
        }

        st = new StringTokenizer(bf.readLine());
        int tryCount = Integer.parseInt(st.nextToken());
        int[] tryArr = new int[tryCount];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < tryCount; i++) {
            tryArr[i] = Integer.parseInt(st.nextToken());
        }
        Deque<Integer> selectedDeque = new ArrayDeque<>();

        for (int index : tryArr) {
            if (!stackArr[index].isEmpty()) {
                Integer pop = stackArr[index].pollLast();
                if (selectedDeque.isEmpty()) {
                    selectedDeque.push(pop);
                    continue;
                }
                if (selectedDeque.peek().equals(pop)) {
                    selectedDeque.pop();
                    answer += 2;
                } else {
                    selectedDeque.push(pop);
                }
            }
        }

        System.out.println(answer);
    }

}
