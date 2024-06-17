package org.example.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Stack_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        String input = st.nextToken();
        Deque<Character> stack = new ArrayDeque<>();
        for (Character ele : input.toCharArray()) {
            if (stack.isEmpty() && ele.equals(')')) {
                System.out.println("NO");
                return;
            }
            if (ele.equals('(')) {
                stack.push(ele);
                continue;
            }
            if (stack.peek()
                .equals('(') && ele.equals(')')) {
                stack.pop();
            }
        }

        if (stack.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

}
