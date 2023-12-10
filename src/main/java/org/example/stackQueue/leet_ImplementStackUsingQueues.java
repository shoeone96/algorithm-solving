package org.example.stackQueue;

import java.util.*;

class leet_ImplementStackUsingQueues {
    private final Queue<Integer> queue1 = new LinkedList<>();
    private final Queue<Integer> queue2 = new LinkedList<>();

    public leet_ImplementStackUsingQueues() {

    }

    public void push(int x) {
        queue1.add(x);
        queue2.clear();
        for (int i = 0; i < queue1.size() - 1; i++) {
            queue2.add(queue1.poll());
            queue1.add(queue2.poll());
        }
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}

/**
 * Your leet_ImplementStackUsingQueues object will be instantiated and called as such:
 * leet_ImplementStackUsingQueues obj = new leet_ImplementStackUsingQueues();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
