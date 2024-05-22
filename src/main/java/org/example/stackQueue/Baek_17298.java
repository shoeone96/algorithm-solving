package org.example.stackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Baek_17298 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] answerArr = new int[n];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder answer = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                stack.push(i);
                continue;
            }

            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                Integer index = stack.pop();
                answerArr[index] = arr[i];
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            Integer leftIndex = stack.pop();
            answerArr[leftIndex] = -1;
        }

        for (int i = 0; i < answerArr.length; i++) {
            answer.append(answerArr[i]).append(" ");
        }

        System.out.println(answer);
    }

}
