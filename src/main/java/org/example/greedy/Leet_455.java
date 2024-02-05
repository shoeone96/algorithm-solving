package org.example.greedy;

import java.util.Arrays;

public class Leet_455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int answer = 0;
        int gLeft = 0;
        int sLeft = 0;
        while(gLeft != g.length -1 && sLeft != s.length -1){
            if(s[sLeft] >= g[gLeft]){
                sLeft++;
                answer++;
                continue;
            }
            gLeft++;
        }
        return answer;

    }
}
