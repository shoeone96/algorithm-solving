package org.example.stackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Queue_7_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        String essential = st.nextToken();
        st = new StringTokenizer(bf.readLine());
        String all = st.nextToken();

        Queue<Character> essentialQueue = new LinkedList<>();
        for(char ele : essential.toCharArray()){
            essentialQueue.offer(ele);
        }

        for(Character ele : all.toCharArray()){
            if(ele.equals(essentialQueue.peek())){
                essentialQueue.poll();
            }
        }

        if(essentialQueue.isEmpty()){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

}
