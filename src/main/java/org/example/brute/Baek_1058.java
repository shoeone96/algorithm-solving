package org.example.brute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_1058 {

    static int N;
    static boolean[] isFriend;
    static char[][] arr;
    static int count;
    static int answer;

    public static void main(String[] args) throws IOException {
        input();
        for (int i = 1; i <= N; i++) {
            isFriend[i] = true;
            dfs(i);
            if (count > answer) {
                answer = count;
            }
            count = 0;
            isFriend = new boolean[N + 1];
        }
        System.out.println(answer);
    }

    private static void dfs(int person) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (arr[person][i] == 'Y' && !isFriend[i]) {
                queue.add(i);
                for (int j = 1; j <= N; j++) {
                    if (arr[i][j] == 'Y' && !isFriend[i]) {
                        queue.add(j);
                    }
                }
            }
        }
        while (!queue.isEmpty()) {
            Integer visit = queue.poll();
            if(!isFriend[visit]){
                isFriend[visit] = true;
                count++;
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        count = 0;
        answer = 0;
        arr = new char[N + 1][N + 1];
        isFriend = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());
            String line = st.nextToken();
            for (int j = 1; j <= N; j++) {
                arr[i][j] = line.charAt(j - 1);
            }
        }
    }

}
