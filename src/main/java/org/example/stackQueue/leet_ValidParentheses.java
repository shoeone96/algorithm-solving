package org.example.stackQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class leet_ValidParentheses {
    public static void main(String[] args) {
        isValid("]");
    }
    public static boolean isValid(String s) {
        boolean answer = true;
        Deque<Character> stack = new ArrayDeque<>();
        for(char ele : s.toCharArray()){
            if( ele == '(' || ele == '{' || ele == '['){
                stack.push(ele);
            }
            if(ele == ')' || ele == '}' || ele == ']'){
                if(stack.isEmpty()){
                    return false;
                }
                char pop = stack.pop();
                if(pop == '(' && ele != ')'){
                    return false;
                }

                if(pop == '{' && ele != '}'){
                    return false;
                }

                if(pop == '[' && ele != ']'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
