package org.example.stackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_11286 {

    static class Abs implements Comparable<Abs> {

        int num;
        int absNum;

        public Abs(int num, int absNum) {
            this.num = num;
            this.absNum = absNum;
        }

        @Override
        public int compareTo(Abs abs) {
            if (this.absNum != abs.absNum) {
                return this.absNum - abs.absNum;
            }
            return this.num - abs.num ;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(st.nextToken());
        StringBuilder answer = new StringBuilder();
        PriorityQueue<Abs> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(st.nextToken());
            int abs = Math.abs(x);
            if (x == 0 && !pq.isEmpty()) {
                Abs printNum = pq.poll();
                answer.append(printNum.num).append("\n");
                continue;
            }
            if (x == 0) {
                answer.append(0).append("\n");
                continue;
            }

            pq.add(new Abs(x, abs));
        }

        System.out.println(answer);
    }

}
