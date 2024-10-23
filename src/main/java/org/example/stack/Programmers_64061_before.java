package org.example.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Programmers_64061_before {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int move : moves) {
            for (int j = 0; j < board[0].length; j++) {
                int index = board[j][move - 1];
                if (index != 0) {
                    board[j][move - 1] = 0;
                    if (!stack.isEmpty() && stack.peek() == index) {
                        stack.pop();
                        answer += 2;
                        break;
                    } else if (!stack.isEmpty()) {
                        stack.push(index);
                        break;
                    }

                    stack.push(index);
                    break;
                }
            }
        }
        return answer;
    }
}
