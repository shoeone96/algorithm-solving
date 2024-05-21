package org.example.stackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek_1874 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder answer = new StringBuilder();
        int start = 1;
        Stack<Integer> stack = new Stack<>();
        for (int num : arr) {

            while (start <= num) {
                stack.push(start++);
                answer.append("+\n");
            }

            if (stack.peek() == num) {
                stack.pop();
                answer.append("-\n");
            } else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println(answer);
    }

}
