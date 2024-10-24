package org.example.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Programmers_81303 {

    public static void main(String[] args) {
        Programmers_81303 solution = new Programmers_81303();
        String[] arr = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
        solution.solution(8, 2, arr);
    }

    public String solution(int n, int k, String[] cmd) {
        String[] answerArr = new String[n];
        Deque<Integer> deletedStack = new ArrayDeque<>();
        Arrays.fill(answerArr, "O");

        for (String command : cmd) {
            if (isMove(command)) {
                String[] commandArr = command.split(" ");
                char direction = command.charAt(0);
                int move = Integer.parseInt(commandArr[1]);
                if (direction == 'U') {
                    k = up(answerArr, k, move);
                } else {
                    k = down(answerArr, k, move);
                }
            } else if (command.equals("C")) {
                k = delete(answerArr, k, deletedStack);
            } else if (command.equals("Z")) {
                k = rollback(answerArr, k, deletedStack);
            }
        }
        return String.join("", answerArr);
    }

    private boolean isMove(String command) {
        return command.startsWith("U") || command.startsWith("D");
    }

    private int up(String[] answerArr, int now, int move) {
        int count = 0;
        int index = now;
        while (count < move && index > 0) {
            index--;
            if (answerArr[index].equals("O")) {
                count++;
            }
        }
        return index;
    }

    private int down(String[] answerArr, int now, int move) {
        int count = 0;
        int index = now;
        while (count < move && index < answerArr.length - 1) {
            index++;
            if (answerArr[index].equals("O")) {
                count++;
            }
        }
        return index;
    }

    private int delete(String[] answerArr, int now, Deque<Integer> stack) {
        answerArr[now] = "X";
        stack.push(now);

        if (now < answerArr.length - 1) {

            int next = now + 1;
            while (next < answerArr.length && answerArr[next].equals("X")) {
                next++;
            }
            if (next < answerArr.length) {
                now = next;
            } else {
                now--;
                while (now >= 0 && answerArr[now].equals("X")) {
                    now--;
                }
            }
        } else {
            now--;
            while (now >= 0 && answerArr[now].equals("X")) {
                now--;
            }
        }
        return now;
    }

    private int rollback(String[] answerArr, int now, Deque<Integer> stack) {
        if (stack.isEmpty()) {
            return now;
        }
        int index = stack.pop();
        answerArr[index] = "O";

        return now;
    }
}
