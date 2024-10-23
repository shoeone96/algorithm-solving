package org.example.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Programmers_64061 {

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Deque<Integer> [] boardStack = new ArrayDeque [board.length];
        for(int i = 0 ; i <board.length;i++){
            boardStack[i] = new ArrayDeque<>();
        }

        for(int i = board.length -1; i >= 0; i--){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] > 0){
                    boardStack[j].push(board[i][j]);
                }
            }
        }

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < moves.length; i++) {
           int index = moves[i] -1;
           if(!boardStack[index].isEmpty()){
               int pop = boardStack[index].pop();
               if(stack.isEmpty()){
                   stack.push(pop);
               } else {
                   if(stack.peek() == pop){
                       stack.pop();
                       answer+=2;
                   } else{
                       stack.push(pop);
                   }
               }
           }
        }
        return answer;
    }

}
