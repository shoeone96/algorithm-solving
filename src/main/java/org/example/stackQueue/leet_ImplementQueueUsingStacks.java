package org.example.stackQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class leet_ImplementQueueUsingStacks {
    public static void main(String[] args) {
        leet_ImplementQueueUsingStacks hi = new leet_ImplementQueueUsingStacks();
        hi.push(1);
        hi.push(2);
        System.out.println(hi.peek());
        System.out.println(hi.pop());
        System.out.println(hi.empty());
    }
    private final Deque<Integer> stack1 = new ArrayDeque<>();
    private final Deque<Integer> stack2 = new ArrayDeque<>();

    public leet_ImplementQueueUsingStacks() {

    }

    public void push(int x) {
        if (stack1.isEmpty()) {
            while (!stack2.isEmpty()) {
                stack1.add(stack2.pop());
            }
        }
        stack1.add(x);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            for (int i = 0; i < stack1.size(); i++) {
                stack2.add(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if (stack2.isEmpty()) {
            for (int i = 0; i < stack1.size(); i++) {
                stack2.add(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
