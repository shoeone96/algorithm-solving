package org.example.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Stack_5 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        String input = st.nextToken();
        Deque<Character> stack = new ArrayDeque<>();
        int answer = 0;
        char[] inputArr = input.toCharArray();
        for (int i = 0; i < inputArr.length; i++) {
            if (inputArr[i] == ')' && inputArr[i - 1] == '(') {
                stack.pop();
                answer += stack.size();
            }
            if (inputArr[i] == ')' && inputArr[i - 1] != '(') {
                answer++;
                stack.pop();
            }
            if (inputArr[i] == '(') {
                stack.push(inputArr[i]);
            }
        }

        System.out.println(answer);
    }

}
