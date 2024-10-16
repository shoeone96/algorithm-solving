package org.example.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Programmers_12909 {

    public static void main(String[] args) {

    }
    // "(" 면 stack에 집어넣기
    // ")"면 stack에서 뽑아내기
    // 만약 뽑을 때 stack.size()가 0이면 return false;
    // 만약 다 돌고서도 Stack이 남아있다면 false
    boolean solution(String s){
        // String 순회
        Deque<Character> stack = new ArrayDeque<>();
        for(char alpha : s.toCharArray()){
            if(alpha == '('){
                stack.push(alpha);
            } else if (alpha == ')'){
                if(stack.isEmpty()){
                    return false;
                } else{
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }

}
