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
        // 하나씩 순회
        for (String command : cmd) {
            // 각 명령어를 판단(움직임, 삭제/복원)
            boolean isMove = isMove(command);
            System.out.println(isMove);

            if (isMove && command.startsWith("D")) { // 움직이면서 아래로 가는 경우
                String[] commandArr = command.split(" ");
                int move = Integer.parseInt(commandArr[commandArr.length - 1]);
                k = down(answerArr, k, move);
            } else if (isMove && command.startsWith("U")) { // 움직이면서 위로 가는 경우
                String[] commandArr = command.split(" ");
                int move = Integer.parseInt(commandArr[commandArr.length - 1]);
                k = up(answerArr, k, move);
            } else if (command.equals("C")) { //삭제하는 경우
                k = delete(answerArr, k, deletedStack);
            } else { //복원하는 경우
                k = rollback(answerArr, k, deletedStack);
            }

        }

        return String.join("", answerArr);
    }

    private boolean isMove(String command) {
        if (command.length() == 3) {
            return true;
        }

        return false;
    }

    private int up(String[] answerArr, int now, int move) {
        int index = now;
        for (int i = index; i > index - move; i--) {
            if (answerArr[i].equals("X")) {
                now = now - 2;
            } else {
                now--;
            }
        }
        System.out.println(Arrays.toString(answerArr));
        System.out.println(now);
        return now;
    }

    private int down(String[] answerArr, int now, int move) {
        int index = now;
        for (int i = index; i < index + move; i++) {
            if (answerArr[i].equals("X")) {
                now = now + 2;
            } else {
                now++;
            }
        }
        System.out.println(Arrays.toString(answerArr));
        System.out.println(now);
        return now;
    }

    private int delete(String[] answerArr, int now, Deque<Integer> stack) {
        answerArr[now] = "X";
        stack.push(now);
        if (now != answerArr.length - 1) {
            now++;
        } else {
            now--;
        }
        System.out.println(Arrays.toString(answerArr));
        System.out.println(now);
        return now;
    }

    private int rollback(String[] answerArr, int now, Deque<Integer> stack) {
        int index = stack.pop();
        answerArr[index] = "O";
        if (index < now) {
            now++;
        }
        System.out.println(Arrays.toString(answerArr));
        System.out.println(now);
        return now;
    }

}
