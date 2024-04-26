package org.example.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_15970 {

    static int N;
    static Comma[] arr;
    static int answer;

    public static void main(String[] args) throws IOException {
        input();
        prod();
    }

    private static void prod() {
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                answer += arr[1].location - arr[0].location;
                continue;
            }
            if (i < arr.length - 1 && arr[i].color == arr[i - 1].color) {
                if (arr[i].color == arr[i + 1].color) {
                    int before = arr[i].location - arr[i - 1].location;
                    int after = arr[i + 1].location - arr[i].location;
                    answer += Math.min(before, after);
                }
                if (arr[i].color != arr[i + 1].color) {
                    int before = arr[i].location - arr[i - 1].location;
                    answer += before;
                }
            }

            if (i < arr.length - 1 && arr[i].color != arr[i - 1].color) {
                int distance = arr[i + 1].location - arr[i].location;
                answer += distance;
            }

            if (i == arr.length - 1) {
                answer += arr[i].location - arr[i - 1].location;
            }
        }

        System.out.println(answer);
    }

    private static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new Comma[N];

        for (int i = 0; i < arr.length; i++) {
            st = new StringTokenizer(bf.readLine());
            int location = Integer.parseInt(st.nextToken());
            int color = Integer.parseInt(st.nextToken());
            Comma comma = new Comma(color, location);
            arr[i] = comma;
        }

        Arrays.sort(arr);
    }

    static class Comma implements Comparable<Comma> {

        int color;
        int location;

        public Comma(int color, int location) {
            this.color = color;
            this.location = location;
        }

        @Override
        public int compareTo(Comma o) {
            if (color != o.color) {
                return color - o.color;
            }
            return location - o.location;
        }

    }

}
