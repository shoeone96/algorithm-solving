package org.example.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Programmers_76502 {

    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            String rotated = s.substring(i) + s.substring(0, i);
            if (isValid(rotated)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isValid(String rotated) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char ele : rotated.toCharArray()) {
            if (ele == '[' || ele == '(' || ele == '{') {
                stack.push(ele);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char word = stack.pop();
                    if (!((word == '(' && ele == ')')
                        || (word == '[' && ele == ']')
                        || (word == '{' && ele == '}'))) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

}
