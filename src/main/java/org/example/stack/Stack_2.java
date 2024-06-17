package org.example.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Stack_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        String input = st.nextToken();
        StringBuilder answer = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        for (Character ele : input.toCharArray()) {
            if (stack.isEmpty() && !ele.equals('(') && !ele.equals(')')) {
                answer.append(ele);
            }

            if(ele.equals('(')){
                stack.add(ele);
            }

            if(ele.equals(')') && !stack.isEmpty()){
                stack.pop();
            }
        }

        System.out.println(answer);
    }

}
