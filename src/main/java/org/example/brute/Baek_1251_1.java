package org.example.brute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1251_1 {

    static String word;
    static String answer;
    static int [] visitedSpace = new int[2];

    public static void main(String[] args) throws IOException {
        input();
        prod(0);
        System.out.println(answer);
    }

    private static void prod(int count) {
        if(count == 2){
            String [] first = word.substring(0, visitedSpace[0] + 1).split("");
            String [] second = word.substring(visitedSpace[0] + 1, visitedSpace[1] + 1).split("");
            String [] third = word.substring(visitedSpace[1] + 1).split("");

            StringBuilder sb = new StringBuilder();
            for(int i = first.length -1; i >= 0; i--){
                sb.append(first[i]);
            }

            for(int i = second.length -1; i >= 0; i--){
                sb.append(second[i]);
            }

            for(int i = third.length -1; i >= 0; i--){
                sb.append(third[i]);
            }

            if (sb.toString().compareTo(answer) < 0){
                answer = sb.toString();
            }
        }

        for(int i = 0; i < word.length() -1; i++){
            if (count == 0){
                visitedSpace[count] = i;
                prod(count + 1);
                visitedSpace[count] = -1;
            }

            if(count == 1 && i > visitedSpace[0]){
                visitedSpace[count] = i;
                prod(count + 1);
                visitedSpace[count] = -1;
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        word = st.nextToken();
        String[] firstAnswerArr = word.split("");
        StringBuilder sb = new StringBuilder();
        for(int i = word.length() - 1; i >= 2; i--){
            sb.append(firstAnswerArr[i]);
        }
        answer = firstAnswerArr[0] + firstAnswerArr[1] + sb;
    }

}

