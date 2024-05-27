package org.example.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2023 {

    static int N;
    static StringBuilder answer;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        answer = new StringBuilder();

        if (N == 1) {
            System.out.println(4);
            return;
        }

        int[] basic = {2, 3, 5, 7};

        for (int i = 0; i < 4; i++) {
            dfs(basic[i], 1);
        }
        System.out.println(answer.toString());
    }

    private static void dfs(int number, int count) {
        if (count == N) {
            answer.append(number)
                .append("\n");
            return;
        }

        number *= 10;
        for (int i = 1; i < 10; i += 2) {
            int candidate = number + i;
            boolean possible = true;
            for (int j = 2; j < candidate / 2; j++) {
                if (candidate % j == 0) {
                    possible = false;
                    break;
                }
            }
            if (possible) {
                dfs(candidate, count + 1);
            }
        }
    }

}
