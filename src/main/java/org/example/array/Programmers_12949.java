package org.example.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programmers_12949 {

    public static void main(String[] args) {

        Programmers_12949 programmers12949 = new Programmers_12949();
        int[][] solution = programmers12949.solution(new int[][]{{1, 4}, {3, 2}, {4, 1}},
            new int[][]{{3, 3}, {3, 3}});
        System.out.println(Arrays.toString(solution));

    }

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int length1 = arr1.length;
        int length2 = arr1[0].length;
        int length3 = arr2[0].length;
        int[][] answer = new int[length1][length3];

        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length3; j++) {
                int sum = 0;
                for (int k = 0; k < length2; k++) {
                    sum += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = sum;
            }
        }

        return answer;
    }

}
