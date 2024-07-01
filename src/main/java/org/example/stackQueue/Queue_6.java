package org.example.stackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Queue_6 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> arr = new ArrayList<>();
        for(int i = 1; i <= N; i++){
            arr.add(i);
        }

        int removeIndex = K -1;
        while(true){
            arr.remove(removeIndex);
            if(arr.size() == 1){
                break;
            }
            removeIndex = removeIndex + K - 1;
            if(removeIndex > arr.size() -1){
                removeIndex = removeIndex % arr.size();
            }
        }
        System.out.println(arr.get(0));
    }

}
