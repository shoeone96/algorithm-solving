package org.example.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Stack_4 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        String[] splitInput = st.nextToken()
            .split("");
        Deque<Integer> stack = new ArrayDeque<>();
        for (String ele : splitInput) {
            if (ele.equals("+") || ele.equals("-") || ele.equals("/") || ele.equals("*")) {
                int a = stack.pop();
                int b = stack.pop();
                switch (ele) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(b - a);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    default:
                        stack.push(b / a);
                }
            } else {
                stack.push(Integer.parseInt(ele));
            }
        }
        System.out.println(stack.pop());
    }

}
