package org.example.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Hash_4 {

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        String S = st.nextToken();
        st = new StringTokenizer(bf.readLine());
        String T = st.nextToken();
        Map<Character, Integer> anaMap = new HashMap<>();
        for (char ele : T.toCharArray()) {
            anaMap.put(ele, anaMap.getOrDefault(ele, 0) + 1);
        }
        int lt = 0;
        int rt = T.length() - 1;
        Map<Character, Integer> compareMap = new HashMap<>();
        for (int i = lt; i <= rt; i++) {
            compareMap.put(S.charAt(i), compareMap.getOrDefault(S.charAt(i), 0) + 1);
        }
        if(anaMap.equals(compareMap)) {
            answer++;
        }
        lt++;
        rt++;
        while (rt < S.length()) {
            Integer beforeValue = compareMap.get(S.charAt(lt - 1));
            if (beforeValue == 1) {
                compareMap.remove(S.charAt(lt - 1));
            } else {
                compareMap.put(S.charAt(lt - 1), compareMap.get(S.charAt(lt - 1)) - 1);
            }
            compareMap.put(S.charAt(rt), compareMap.getOrDefault(S.charAt(rt), 0) + 1);
            if(anaMap.equals(compareMap)) {
                answer++;
            }
            lt++;
            rt++;
        }
        System.out.println(answer);
    }

}
