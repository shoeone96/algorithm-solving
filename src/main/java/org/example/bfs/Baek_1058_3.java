package org.example.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_1058_3 {

    static int N;
    static boolean[][] arr;
    static boolean[] isFriend;
    static int answer;

    public static void main(String[] args) throws IOException {
        input();
        for (int i = 0; i < N; i++) {
            prod(i);
        }
        System.out.println(answer);
    }

    private static void prod(int person) {
        isFriend = new boolean[N];
        int count = 0;
        Queue<Integer> friendIndex = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            if(person == i) continue;
            if(arr[person][i]){
                friendIndex.add(i);
                for(int j = 0; j < N; j++){
                    if(i == j) continue;
                    if(arr[i][j]){
                        friendIndex.add(j);
                    }
                }
            }
        }

        while(!friendIndex.isEmpty()){
            Integer polledFriend = friendIndex.poll();
            if (!isFriend[polledFriend] && polledFriend != person){
                isFriend[polledFriend] = true;
                count++;
            }
        }

        if(count > answer){
            answer = count;
        }
    }

    private static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        answer = 0;
        N = Integer.parseInt(st.nextToken());
        arr = new boolean[N][N];
        isFriend = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String line = st.nextToken();
            char[] friends = line.toCharArray();
            for (int j = 0; j < friends.length; j++) {
                if (friends[j] == 'Y') {
                    arr[i][j] = true;
                }
            }
        }
    }

}
