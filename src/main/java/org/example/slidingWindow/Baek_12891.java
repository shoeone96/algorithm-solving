package org.example.slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_12891 {

    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        int[] condition = new int[4];
        int[] real = new int[4];

        String word = st.nextToken();

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < condition.length; i++) {
            condition[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = left + P - 1;

        while (left <= word.length() - P) {
            if (left == 0) {
                for (int j = 0; j < P; j++) {
                    if (word.charAt(j) == 'A') {
                        real[0]++;
                    }
                    if (word.charAt(j) == 'C') {
                        real[1]++;
                    }
                    if (word.charAt(j) == 'G') {
                        real[2]++;
                    }
                    if (word.charAt(j) == 'T') {
                        real[3]++;
                    }
                }
            } else {
                if (word.charAt(left - 1) == 'A') {
                    real[0]--;
                }
                if (word.charAt(left - 1) == 'C') {
                    real[1]--;
                }
                if (word.charAt(left - 1) == 'G') {
                    real[2]--;
                }
                if (word.charAt(left - 1) == 'T') {
                    real[3]--;
                }
                if (word.charAt(right) == 'A') {
                    real[0]++;
                }
                if (word.charAt(right) == 'C') {
                    real[1]++;
                }
                if (word.charAt(right) == 'G') {
                    real[2]++;
                }
                if (word.charAt(right) == 'T') {
                    real[3]++;
                }
            }
            if (real[0] >= condition[0] &&
                real[1] >= condition[1] &&
                real[2] >= condition[2] &&
                real[3] >= condition[3]) {
                answer++;
            }
            left++;
            right++;
        }
        System.out.println(answer);

    }

}
