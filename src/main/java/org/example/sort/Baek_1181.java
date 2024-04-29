package org.example.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Baek_1181 {

    static int N;
    static String [] arr;

    public static void main(String[] args) throws IOException {
        input();
        prod();
    }

    private static void prod() {
        if(arr.length == 1){
            System.out.println(arr[0]);
            return;
        }
        List<String> list = Arrays.stream(arr)
            .sorted(Comparator.comparing(String::length)
                .thenComparing(String::compareTo))
            .distinct()
            .toList();

        StringBuilder sb  = new StringBuilder();
        for (String s : list) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }

    public static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new String [N];

        for(int i = 0; i < N; i ++){
            st = new StringTokenizer(bf.readLine());
            arr[i] = st.nextToken();
        }

    }

}
