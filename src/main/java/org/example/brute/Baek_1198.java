package org.example.brute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baek_1198 {

    static int N;
    static List<Integer[]> location;
    static float answer;

    public static void main(String[] args) throws IOException {
        input();
        for (int i = 0; i < N; i++) {
            prod(i);
        }
        System.out.println(answer);
    }

    private static void prod(int i) {
        Integer[] first = location.get(i);
        Integer[] second = location.get((i + 1) % location.size());
        Integer[] third = location.get((i + 2) % location.size());

        calculate(first, second, third);
    }

    private static void calculate(Integer[] first, Integer[] second, Integer[] third) {
        int column = 0;
        int row = 0;
        if(first[1]>  column){
            column = first[1];
        }

        if(second[1]>  column){
            column = second[1];
        }

        if(third[1]>  column){
            column = third[1];
        }
        if(first[0]>  row){
            row = first[0];
        }

        if(second[0]>  row){
            row = second[0];
        }

        if(third[0]>  row){
            row = third[0];
        }

        float square = column * row;
        float firstTri = (float) (Math.abs(first[0] - second[0]) * Math.abs(first[1] - second[1])) / 2;
        float secondTri = (float) (Math.abs(second[0] - third[0]) * Math.abs(second[1] - third[1])) / 2;
        float thirdTri = (float) (Math.abs(third[0] - first[0]) * Math.abs(third[1] - first[1])) / 2;

        float sum = square - firstTri -secondTri - thirdTri;
        if(sum > answer){
            answer = sum;
        }
    }

    static void input() throws IOException {
        answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        location = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Integer[] arr = new Integer[2];
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            location.add(arr);
        }
    }

}
