package org.example.brute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leet_51 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> answer = new ArrayList<>();
        Set<Integer> sumCheck = new HashSet<>();
        Set<Integer> minusCheck = new HashSet<>();
        Set<Integer> isVisited = new HashSet<>();
        String[][] arr = new String[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = ".";
            }
        }
        prod(answer, sumCheck, minusCheck, arr, isVisited, 0);
        return answer;
    }

    private void prod(
        List<List<String>> answer,
        Set<Integer> sumCheck,
        Set<Integer> minusCheck,
        String[][] arr,
        Set<Integer> isVisited, int count
    ) {
        if (count == arr.length) {
            List<String> one = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < arr[0].length; j++){
                    sb.append(arr[i][j]);
                }
                one.add(sb.toString());
            }
            answer.add(one);
            return;
        }

        for(int i = 0; i < arr.length; i++){
            if(isValid(count, i, sumCheck, minusCheck, isVisited)){
                arr[count][i] = "Q";
                isVisited.add(i);
                sumCheck.add(count + i);
                minusCheck.add(count - i);
                prod(answer, sumCheck, minusCheck, arr, isVisited, count + 1);
                isVisited.remove(i);
                sumCheck.remove(count + i);
                minusCheck.remove(count - i);
                arr[count][i] = ".";
            }
        }
    }

    private boolean isValid(
        int row, int col,
        Set<Integer> sumCheck,
        Set<Integer> minusCheck,
        Set<Integer> isVisited
    ){
        if(isVisited.contains(col)){
            return false;
        }

        if(sumCheck.contains(row + col)){
            return false;
        }

        if(minusCheck.contains(row - col)){
            return false;
        }

        return true;
    }

}
