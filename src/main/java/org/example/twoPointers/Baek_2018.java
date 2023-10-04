package org.example.twoPointers;

import java.util.Scanner;

public class Baek_2018 {
    public static int input(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static void solution(int input){
        int lt = 1;
        int rt = 1;
        int sum = 1;
        int answer = 0;
        while(rt <= input){
            if(sum < input) {
                sum += ++rt;
            } else if (sum == input) {
                answer++;
                sum -= lt++;
            } else {
                while(sum > input){
                    sum -= lt++;
                    if(sum == input) {
                        answer++;
                        sum -= lt++;
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args){
        Baek_2018.solution(Baek_2018.input());
    }
}
