package org.example.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Hash_5 {

    static int N, K;
    static int [] arr;
    static TreeSet<Integer> answerArr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        answerArr = new TreeSet<>(Comparator.reverseOrder());

        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backTracking(0, 0, 0);
        if(K >= answerArr.size()){
            System.out.println(-1);
            return;
        }
        int count = 0;
        for(Integer ele : answerArr){
            count++;
            if(count == K){
                System.out.println(ele);
                return;
            }
        }
    }

    private static void backTracking(int count, int sum, int index) {
        if(count == 3){
            answerArr.add(sum);
            return;
        }

        for(int i = index; i < N; i++){
            sum += arr[i];
            backTracking(count + 1, sum, i  + 1);
            sum -= arr[i];
        }
    }

}
